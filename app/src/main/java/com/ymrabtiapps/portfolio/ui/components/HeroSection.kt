package com.ymrabtiapps.portfolio.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ymrabtiapps.portfolio.R
import com.ymrabtiapps.portfolio.data.model.PersonalInfo
import com.ymrabtiapps.portfolio.ui.theme.*
import kotlin.random.Random

@Composable
fun HeroSection(
    personalInfo: PersonalInfo,
    onScrollDown: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        DarkBackground,
                        DarkSurface
                    )
                )
            )
    ) {
        // Background shapes
        BackgroundShapes(
            modifier = Modifier.matchParentSize()
        )
        
        // Animated background particles
        AnimatedParticles(
            modifier = Modifier.matchParentSize()
        )
        
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(top = 60.dp, bottom = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Avatar with ring
            Box(
                modifier = Modifier.padding(bottom = 24.dp),
                contentAlignment = Alignment.Center
            ) {
                // Animated ring
                AnimatedAvatarRing()
                
                // Avatar image
                AsyncImage(
                    model = personalInfo.avatarUrl,
                    contentDescription = personalInfo.name,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(DarkSurface),
                    contentScale = ContentScale.Crop,
                    error = painterResource(id = R.drawable.ic_launcher_foreground),
                    placeholder = painterResource(id = R.drawable.ic_launcher_foreground)
                )
            }
            
            // Name
            Text(
                text = personalInfo.name,
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp
                ),
                color = Color.White,
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Tagline
            Text(
                text = personalInfo.tagline,
                style = MaterialTheme.typography.titleMedium,
                color = PrimaryColor,
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Description
            Text(
                text = personalInfo.description,
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary,
                textAlign = TextAlign.Center,
                lineHeight = 24.sp
            )
            
            Spacer(modifier = Modifier.height(48.dp))
            
            // Scroll down indicator
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(
                    text = "Scroll Down to Explore",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextMuted
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Animated arrow
                val infiniteTransition = rememberInfiniteTransition(label = "scroll")
                val offsetY by infiniteTransition.animateFloat(
                    initialValue = 0f,
                    targetValue = 10f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(1000, easing = EaseInOutSine),
                        repeatMode = RepeatMode.Reverse
                    ),
                    label = "offset"
                )
                
                IconButton(
                    onClick = onScrollDown,
                    modifier = Modifier.offset(y = offsetY.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Scroll down",
                        tint = PrimaryColor,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun AnimatedAvatarRing() {
    val infiniteTransition = rememberInfiniteTransition(label = "ring")
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(10000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "rotation"
    )
    
    Canvas(modifier = Modifier.size(140.dp)) {
        drawCircle(
            brush = Brush.sweepGradient(
                colors = listOf(
                    PrimaryColor,
                    SecondaryColor,
                    AccentColor,
                    PrimaryColor
                )
            ),
            radius = size.minDimension / 2,
            style = androidx.compose.ui.graphics.drawscope.Stroke(width = 4.dp.toPx())
        )
    }
}

@Composable
private fun AnimatedParticles(
    modifier: Modifier = Modifier
) {
    val particles = remember {
        List(20) {
            Particle(
                x = Random.nextFloat(),
                y = Random.nextFloat(),
                size = Random.nextFloat() * 4 + 2,
                alpha = Random.nextFloat() * 0.5f + 0.1f
            )
        }
    }
    
    val infiniteTransition = rememberInfiniteTransition(label = "particles")
    val offset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(5000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "particleOffset"
    )
    
    Canvas(modifier = modifier.fillMaxSize()) {
        particles.forEach { particle ->
            val yOffset = (particle.y + offset) % 1f
            drawCircle(
                color = PrimaryColor.copy(alpha = particle.alpha),
                radius = particle.size.dp.toPx(),
                center = Offset(
                    x = particle.x * size.width,
                    y = yOffset * size.height
                )
            )
        }
    }
}

@Composable
private fun BackgroundShapes(
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier.fillMaxSize()) {
        // Large circle top-right
        drawCircle(
            color = PrimaryColor.copy(alpha = 0.1f),
            radius = 200.dp.toPx(),
            center = Offset(size.width + 50.dp.toPx(), -50.dp.toPx())
        )
        
        // Medium circle bottom-left
        drawCircle(
            color = SecondaryColor.copy(alpha = 0.08f),
            radius = 150.dp.toPx(),
            center = Offset(-50.dp.toPx(), size.height - 100.dp.toPx())
        )
    }
}

private data class Particle(
    val x: Float,
    val y: Float,
    val size: Float,
    val alpha: Float
)
