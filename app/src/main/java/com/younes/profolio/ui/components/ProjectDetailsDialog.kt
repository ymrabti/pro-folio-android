package com.younes.profolio.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Launch
import androidx.compose.material.icons.filled.Store
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import com.younes.profolio.ui.components.PortfolioImage
import com.younes.profolio.data.model.Project
import com.younes.profolio.ui.theme.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import com.younes.profolio.ui.components.icons.TechIcon

@Composable
fun ProjectDetailsDialog(
    project: Project,
    onDismiss: () -> Unit
) {
    val uriHandler = LocalUriHandler.current

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            color = DarkSurface,
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                // Header image
                project.imageUrl?.let { image ->
                    PortfolioImage(
                        source = image,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }

                // Title + close
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = project.title,
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                        color = Color.White,
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(onClick = onDismiss) {
                        Icon(Icons.Default.Close, contentDescription = "Close", tint = TextSecondary)
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))
                StatusBadge(status = project.status)

                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = project.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextSecondary
                )

                // Technologies (top-level)
                if (project.technologies.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Technologies",
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.SemiBold),
                        color = PrimaryColor
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        project.technologies.forEach { tech ->
                            AssistChip(
                                onClick = {},
                                label = { Text(tech.name) },
                                leadingIcon = {
                                    TechIcon(key = tech.icon ?: tech.name, tint = PrimaryColor)
                                },
                                colors = AssistChipDefaults.assistChipColors(
                                    labelColor = PrimaryColor,
                                    containerColor = PrimaryColor.copy(alpha = 0.15f)
                                )
                            )
                        }
                    }
                }

                // Features
                if (project.features.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Key Features",
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.SemiBold),
                        color = PrimaryColor
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        project.features.forEach { feature ->
                            Surface(
                                color = DarkSurfaceVariant,
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Column(modifier = Modifier.padding(12.dp)) {
                                    Text(
                                        text = feature.title,
                                        style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.SemiBold),
                                        color = Color.White
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = feature.description,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = TextSecondary
                                    )
                                    if (feature.technologies.isNotEmpty()) {
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                                        ) {
                                            feature.technologies.forEach { t ->
                                                AssistChip(
                                                    onClick = {},
                                                    label = { Text(t.name) },
                                                    leadingIcon = {
                                                        TechIcon(key = t.icon ?: t.name, tint = PrimaryColor)
                                                    },
                                                    colors = AssistChipDefaults.assistChipColors(
                                                        labelColor = PrimaryColor,
                                                        containerColor = PrimaryColor.copy(alpha = 0.15f)
                                                    )
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                // Actions
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    project.githubUrl?.let { url ->
                        OutlinedButton(onClick = { uriHandler.openUri(url) }) {
                            Icon(Icons.Default.Code, contentDescription = null)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("GitHub")
                        }
                    }
                    project.liveUrl?.let { url ->
                        OutlinedButton(onClick = { uriHandler.openUri(url) }) {
                            Icon(Icons.Default.Launch, contentDescription = null)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Live Demo")
                        }
                    }
                    project.playStoreUrl?.let { url ->
                        OutlinedButton(onClick = { uriHandler.openUri(url) }) {
                            Icon(Icons.Default.Store, contentDescription = null)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Play Store")
                        }
                    }
                }
            }
        }
    }
}
