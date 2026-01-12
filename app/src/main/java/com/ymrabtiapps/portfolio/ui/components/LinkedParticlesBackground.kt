package com.ymrabtiapps.portfolio.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.ymrabtiapps.portfolio.ui.theme.*
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.random.Random

data class LinkedParticle(
    val baseX: Float,
    val baseY: Float,
    val vx: Float,
    val vy: Float,
    val size: Float,
    val alpha: Float,
    val parallaxFactor: Float // Different speeds for parallax effect
)

@Composable
fun LinkedParticlesBackground(
    modifier: Modifier = Modifier,
    particleCount: Int = 35,
    connectionDistance: Float = 100f
) {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current
    
    val screenWidthPx = with(density) { configuration.screenWidthDp.dp.toPx() }
    val screenHeightPx = with(density) { configuration.screenHeightDp.dp.toPx() }
    val connectionDistancePx = with(density) { connectionDistance.dp.toPx() }
    
    // Create particles with varying parallax factors
    val particles = remember(screenWidthPx, screenHeightPx) {
        List(particleCount) {
            LinkedParticle(
                baseX = Random.nextFloat() * screenWidthPx,
                baseY = Random.nextFloat() * screenHeightPx,
                vx = (Random.nextFloat() - 0.5f) * 0.8f,
                vy = (Random.nextFloat() - 0.5f) * 0.8f,
                size = Random.nextFloat() * 2.5f + 1.5f,
                alpha = Random.nextFloat() * 0.5f + 0.15f,
                parallaxFactor = Random.nextFloat() * 0.5f + 0.5f // 0.5 to 1.0
            )
        }
    }
    
    // Continuous time animation for smooth movement
    val infiniteTransition = rememberInfiniteTransition(label = "particles")
    
    val timeX by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(20000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "timeX"
    )
    
    val timeY by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(25000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "timeY"
    )
    
    // Calculate animated positions
    val animatedParticles = remember(timeX, timeY, screenWidthPx, screenHeightPx) {
        particles.map { particle ->
            // Smooth parallax movement using sine/cosine for organic motion
            val offsetX = sin(Math.toRadians((timeX * particle.parallaxFactor).toDouble())).toFloat() * 50f * particle.parallaxFactor
            val offsetY = cos(Math.toRadians((timeY * particle.parallaxFactor * 0.7f).toDouble())).toFloat() * 40f * particle.parallaxFactor
            
            // Linear drift
            val driftX = (timeX * particle.vx) % screenWidthPx
            val driftY = (timeY * particle.vy * 0.5f) % screenHeightPx
            
            // Calculate new position with wrapping
            var newX = particle.baseX + offsetX + driftX
            var newY = particle.baseY + offsetY + driftY
            
            // Wrap around screen edges smoothly
            while (newX < 0) newX += screenWidthPx
            while (newX > screenWidthPx) newX -= screenWidthPx
            while (newY < 0) newY += screenHeightPx
            while (newY > screenHeightPx) newY -= screenHeightPx
            
            Pair(Offset(newX, newY), particle)
        }
    }
    
    Canvas(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        DarkBackground,
                        DarkSurface.copy(alpha = 0.98f)
                    )
                )
            )
    ) {
        // Draw connections between nearby particles
        for (i in animatedParticles.indices) {
            for (j in i + 1 until animatedParticles.size) {
                val (pos1, p1) = animatedParticles[i]
                val (pos2, p2) = animatedParticles[j]
                
                val dx = pos2.x - pos1.x
                val dy = pos2.y - pos1.y
                val distance = sqrt(dx * dx + dy * dy)
                
                if (distance < connectionDistancePx) {
                    // Alpha based on distance (closer = more visible)
                    val lineAlpha = (1f - distance / connectionDistancePx) * 0.25f * 
                        ((p1.alpha + p2.alpha) / 2f)
                    
                    drawLine(
                        color = PrimaryColor.copy(alpha = lineAlpha),
                        start = pos1,
                        end = pos2,
                        strokeWidth = 0.8f.dp.toPx(),
                        cap = StrokeCap.Round
                    )
                }
            }
        }
        
        // Draw particles
        animatedParticles.forEach { (position, particle) ->
            // Draw outer glow
            drawCircle(
                color = PrimaryColor.copy(alpha = particle.alpha * 0.2f),
                radius = particle.size.dp.toPx() * 3f,
                center = position
            )
            
            // Draw inner glow
            drawCircle(
                color = PrimaryColor.copy(alpha = particle.alpha * 0.4f),
                radius = particle.size.dp.toPx() * 1.8f,
                center = position
            )
            
            // Draw particle core
            drawCircle(
                color = PrimaryColor.copy(alpha = particle.alpha * 0.9f),
                radius = particle.size.dp.toPx(),
                center = position
            )
        }
    }
}
