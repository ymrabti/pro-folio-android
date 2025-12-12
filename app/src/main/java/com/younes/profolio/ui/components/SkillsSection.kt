package com.younes.profolio.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.younes.profolio.data.model.Skill
import com.younes.profolio.data.model.SkillCategory
import com.younes.profolio.ui.theme.*

@Composable
fun SkillsSection(
    skills: List<Skill>,
    modifier: Modifier = Modifier
) {
    var selectedCategory by remember { mutableStateOf(SkillCategory.DEV) }
    val filteredSkills = skills.filter { it.category == selectedCategory }
    
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(DarkSurface)
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
                text = "Technical Skills & Expertise",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = Color.White
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = "Technologies and tools I use to build amazing solutions",
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
            items(SkillCategory.values()) { category ->
                CategoryTab(
                    category = category,
                    isSelected = category == selectedCategory,
                    onClick = { selectedCategory = category }
                )
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Skills grid
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .animateContentSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            filteredSkills.forEach { skill ->
                SkillItem(skill = skill)
            }
        }
    }
}

@Composable
private fun CategoryTab(
    category: SkillCategory,
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
private fun SkillItem(skill: Skill) {
    val animatedProgress = remember { Animatable(0f) }
    
    LaunchedEffect(skill) {
        animatedProgress.animateTo(
            targetValue = skill.level / 100f,
            animationSpec = tween(1000, easing = EaseOutCubic)
        )
    }
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = DarkSurfaceVariant
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = skill.name,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = Color.White
                )
                
                Text(
                    text = "${skill.level}%",
                    style = MaterialTheme.typography.labelLarge,
                    color = getCategoryColor(skill.category)
                )
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Progress bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color.White.copy(alpha = 0.1f))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(animatedProgress.value)
                        .clip(RoundedCornerShape(4.dp))
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(
                                    getCategoryColor(skill.category),
                                    getCategoryColor(skill.category).copy(alpha = 0.7f)
                                )
                            )
                        )
                )
            }
            
            skill.description?.let { description ->
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = TextMuted
                )
            }
        }
    }
}

private fun getCategoryColor(category: SkillCategory): Color {
    return when (category) {
        SkillCategory.DEV -> DevColor
        SkillCategory.OPS -> OpsColor
        SkillCategory.DATABASE -> DatabaseColor
        SkillCategory.GIS -> GisColor
        SkillCategory.IDE -> IdeColor
    }
}
