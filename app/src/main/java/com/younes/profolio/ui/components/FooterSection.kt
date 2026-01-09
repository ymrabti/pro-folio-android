package com.younes.profolio.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.younes.profolio.data.model.ExternalLink
import com.younes.profolio.ui.theme.*

@Composable
fun FooterSection(
    externalLinks: List<ExternalLink>,
    onBackToTop: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current
    
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(DarkBackground)
            .padding(vertical = 24.dp, horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Section title
        Text(
            text = "Let's Connect",
            style = MaterialTheme.typography.headlineSmall,
            color = TextPrimary,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = "Find me on these platforms",
            style = MaterialTheme.typography.bodyMedium,
            color = TextSecondary
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Social links with icons, platform name and description
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            externalLinks.forEach { link ->
                val (icon, iconColor) = getSocialIconAndColor(link.platform)
                
                SocialLinkItem(
                    icon = icon,
                    iconColor = iconColor,
                    platform = link.platform,
                    description = link.description,
                    onClick = { uriHandler.openUri(link.url) }
                )
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Back to top button
        TextButton(
            onClick = onBackToTop
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = null,
                tint = PrimaryColor
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Back to Top",
                color = PrimaryColor
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        HorizontalDivider(
            color = DarkSurfaceVariant,
            thickness = 1.dp
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Copyright
        Text(
            text = "© 2026 Younes MRABTI. All rights reserved.",
            style = MaterialTheme.typography.bodySmall,
            color = TextMuted,
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(4.dp))
        
        Text(
            text = "Built with ❤️ using Jetpack Compose",
            style = MaterialTheme.typography.bodySmall,
            color = TextMuted,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun SocialLinkItem(
    icon: ImageVector,
    iconColor: Color,
    platform: String,
    description: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(DarkSurfaceVariant.copy(alpha = 0.5f))
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icon container
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(iconColor.copy(alpha = 0.15f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = platform,
                tint = iconColor,
                modifier = Modifier.size(24.dp)
            )
        }
        
        Spacer(modifier = Modifier.width(16.dp))
        
        // Text content
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = platform,
                style = MaterialTheme.typography.bodyLarge,
                color = TextPrimary,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary
            )
        }
        
        // Arrow icon
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = null,
            tint = TextMuted,
            modifier = Modifier.size(20.dp)
        )
    }
}

private fun getSocialIconAndColor(platform: String): Pair<ImageVector, Color> {
    return when {
        platform == "GitHub - Main Profile" -> Pair(Icons.Default.Code, Color.White)
        platform == "GitHub - Flutter Packages" -> Pair(Icons.Default.Extension, Color(0xFF02569B))
        platform == "GitHub - Flutter Apps" -> Pair(Icons.Default.PhoneAndroid, Color(0xFF3DDC84))
        platform == "LinkedIn" -> Pair(Icons.Default.Business, Color(0xFF0077B5))
        platform == "Patreon" -> Pair(Icons.Default.Favorite, Color(0xFFFF424D))
        else -> Pair(Icons.Default.Link, Color.Gray)
    }
}
