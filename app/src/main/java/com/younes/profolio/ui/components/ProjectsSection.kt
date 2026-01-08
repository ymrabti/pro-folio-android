package com.younes.profolio.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.younes.profolio.data.model.Project
import com.younes.profolio.data.model.ProjectCategory
import com.younes.profolio.data.model.ProjectStatus
import com.younes.profolio.data.model.Technology
import com.younes.profolio.ui.theme.*
import coil.compose.AsyncImage
import com.younes.profolio.ui.components.PortfolioImage
import com.younes.profolio.ui.components.icons.TechIcon

@Composable
fun ProjectsSection(
    projects: List<Project>,
    modifier: Modifier = Modifier
) {
    var selectedCategory by remember { mutableStateOf(ProjectCategory.FULLSTACK) }
    val filteredProjects = projects.filter { it.category == selectedCategory }
    var expandedProjectId by remember { mutableStateOf<String?>(null) }
    var dialogProject by remember { mutableStateOf<Project?>(null) }
    
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(DarkBackground)
            .padding(vertical = 32.dp)
    ) {
        // Header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Featured Projects",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = Color.White
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = "Innovative solutions across web, mobile, and GIS platforms",
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary
            )
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Category tabs
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(ProjectCategory.values()) { category ->
                ProjectCategoryTab(
                    category = category,
                    isSelected = category == selectedCategory,
                    onClick = { 
                        selectedCategory = category 
                        expandedProjectId = null
                    }
                )
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Projects list
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            filteredProjects.forEach { project ->
                ProjectCard(
                    project = project,
                    isExpanded = expandedProjectId == project.id,
                    onToggleExpand = {
                        expandedProjectId = if (expandedProjectId == project.id) null else project.id
                    },
                    onShowDetails = { dialogProject = project }
                )
            }
        }
    }
    // Details dialog
    dialogProject?.let { p ->
        ProjectDetailsDialog(
            project = p,
            onDismiss = { dialogProject = null }
        )
    }
}

@Composable
private fun ProjectCategoryTab(
    category: ProjectCategory,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (isSelected) PrimaryColor else DarkSurfaceVariant
    val textColor = if (isSelected) Color.White else TextSecondary
    
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor
        ),
        shape = RoundedCornerShape(20.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = category.displayName,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
private fun ProjectCard(
    project: Project,
    isExpanded: Boolean,
    onToggleExpand: () -> Unit,
    onShowDetails: () -> Unit
) {
    val uriHandler = LocalUriHandler.current
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = DarkSurface
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Optional project image
            project.imageUrl?.let { image ->
                PortfolioImage(
                    source = image,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
            // Header row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = project.title,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = Color.White
                    )
                    
                    Spacer(modifier = Modifier.height(4.dp))
                    
                    StatusBadge(status = project.status)
                }
                
                IconButton(onClick = onToggleExpand) {
                    Icon(
                        imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                        contentDescription = if (isExpanded) "Collapse" else "Expand",
                        tint = TextSecondary
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Description
            Text(
                text = project.description,
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary,
                maxLines = if (isExpanded) Int.MAX_VALUE else 2,
                overflow = TextOverflow.Ellipsis
            )
            
            // Expanded content
            AnimatedVisibility(
                visible = isExpanded,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Column {
                    if (project.features.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        Text(
                            text = "Key Features",
                            style = MaterialTheme.typography.titleSmall.copy(
                                fontWeight = FontWeight.SemiBold
                            ),
                            color = PrimaryColor
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        project.features.forEach { feature ->
                            FeatureItem(
                                title = feature.title,
                                description = feature.description,
                                technologies = feature.technologies
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                    
                    // Action buttons
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        project.githubUrl?.let { url ->
                            ActionButton(
                                text = "GitHub",
                                icon = Icons.Default.Code,
                                onClick = { uriHandler.openUri(url) }
                            )
                        }
                        
                        project.liveUrl?.let { url ->
                            ActionButton(
                                text = "Live Demo",
                                icon = Icons.Default.Launch,
                                onClick = { uriHandler.openUri(url) }
                            )
                        }
                        
                        project.playStoreUrl?.let { url ->
                            ActionButton(
                                text = "Play Store",
                                icon = Icons.Default.Store,
                                onClick = { uriHandler.openUri(url) }
                            )
                        }
                    }
                }
            }
            
            // View more button when collapsed
            if (!isExpanded) {
                Spacer(modifier = Modifier.height(8.dp))
                
                TextButton(
                    onClick = onShowDetails,
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = PrimaryColor
                    )
                ) {
                    Text("View Details")
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun StatusBadge(status: ProjectStatus) {
    val (color, icon) = when (status) {
        ProjectStatus.COMPLETED -> SuccessColor to Icons.Default.CheckCircle
        ProjectStatus.ONGOING -> WarningColor to Icons.Default.Schedule
        ProjectStatus.PLANNED -> InfoColor to Icons.Default.Event
    }
    
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(
                color = color.copy(alpha = 0.1f),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = color,
            modifier = Modifier.size(14.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = status.displayName,
            style = MaterialTheme.typography.labelSmall,
            color = color
        )
    }
}

@Composable
private fun FeatureItem(
    title: String,
    description: String,
    technologies: List<Technology>
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = DarkSurfaceVariant
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                color = Color.White
            )
            
            Spacer(modifier = Modifier.height(4.dp))
            
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary
            )
            
            if (technologies.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    technologies.take(3).forEach { tech ->
                        TechChip(text = tech.name, iconKey = tech.icon ?: tech.name)
                    }
                    if (technologies.size > 3) {
                        TechChip(text = "+${technologies.size - 3}")
                    }
                }
            }
        }
    }
}

@Composable
private fun TechChip(text: String, iconKey: String? = null) {
    Surface(
        color = PrimaryColor.copy(alpha = 0.2f),
        shape = RoundedCornerShape(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
        ) {
            iconKey?.let {
                TechIcon(key = it, tint = PrimaryColor, size = 14.dp)
                Spacer(modifier = Modifier.width(4.dp))
            }
            Text(
                text = text,
                style = MaterialTheme.typography.labelSmall,
                color = PrimaryColor
            )
        }
    }
}

@Composable
private fun ActionButton(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = PrimaryColor
        ),
        border = ButtonDefaults.outlinedButtonBorder.copy(
            brush = androidx.compose.ui.graphics.SolidColor(PrimaryColor.copy(alpha = 0.5f))
        ),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium
        )
    }
}
