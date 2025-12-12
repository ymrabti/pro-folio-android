package com.younes.profolio.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
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
        
        // Social links
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            externalLinks.forEach { link ->
                val icon = when {
                    link.platform.contains("GitHub") -> Icons.Default.Code
                    link.platform.contains("LinkedIn") -> Icons.Default.Business
                    link.platform.contains("Patreon") -> Icons.Default.Favorite
                    else -> Icons.Default.Link
                }
                
                IconButton(
                    onClick = { uriHandler.openUri(link.url) }
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = link.platform,
                        tint = TextSecondary
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        HorizontalDivider(
            color = DarkSurfaceVariant,
            thickness = 1.dp
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Copyright
        Text(
            text = "© 2024 Younes MRABTI. All rights reserved.",
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
