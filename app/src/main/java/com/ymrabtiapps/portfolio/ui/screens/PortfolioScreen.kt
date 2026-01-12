package com.ymrabtiapps.portfolio.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.ymrabtiapps.portfolio.data.repository.PortfolioRepository
import com.ymrabtiapps.portfolio.ui.components.*
import com.ymrabtiapps.portfolio.ui.theme.*
import kotlinx.coroutines.launch

enum class PortfolioSection(val title: String, val icon: ImageVector) {
    HERO("Home", Icons.Default.Home),
    SKILLS("Skills", Icons.Default.Star),
    PROJECTS("Projects", Icons.Default.Folder),
    EXPERIENCE("Experience", Icons.Default.Work),
    EDUCATION("Education", Icons.Default.School),
    CONTACT("Contact", Icons.Default.Email)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortfolioScreen() {
    val portfolioData = PortfolioRepository.portfolioData
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    
    // Determine which section is currently visible
    val currentSection by remember {
        derivedStateOf {
            when (listState.firstVisibleItemIndex) {
                0 -> PortfolioSection.HERO
                1 -> PortfolioSection.SKILLS
                2 -> PortfolioSection.PROJECTS
                3 -> PortfolioSection.EXPERIENCE
                4 -> PortfolioSection.EDUCATION
                5, 6 -> PortfolioSection.CONTACT
                else -> PortfolioSection.HERO
            }
        }
    }
    
    Scaffold(
        bottomBar = {
            PortfolioBottomBar(
                currentSection = currentSection,
                onSectionSelected = { section ->
                    coroutineScope.launch {
                        val index = when (section) {
                            PortfolioSection.HERO -> 0
                            PortfolioSection.SKILLS -> 1
                            PortfolioSection.PROJECTS -> 2
                            PortfolioSection.EXPERIENCE -> 3
                            PortfolioSection.EDUCATION -> 4
                            PortfolioSection.CONTACT -> 5
                        }
                        listState.animateScrollToItem(index)
                    }
                }
            )
        },
        containerColor = DarkBackground
    ) { paddingValues ->
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            // Hero Section
            item {
                HeroSection(
                    personalInfo = portfolioData.personalInfo,
                    onScrollDown = {
                        coroutineScope.launch {
                            listState.animateScrollToItem(1)
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            
            // Skills Section
            item {
                SkillsSection(
                    skills = portfolioData.skills,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            
            // Projects Section
            item {
                ProjectsSection(
                    projects = portfolioData.projects,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            
            // Experience Section
            item {
                ExperienceSection(
                    contributions = portfolioData.professionalContributions,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            
            // Education Section
            item {
                EducationSection(
                    educations = portfolioData.educations,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            
            // Contact Section
            item {
                ContactSection(
                    personalInfo = portfolioData.personalInfo,
                    externalLinks = portfolioData.externalLinks,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            
            // Footer
            item {
                FooterSection(
                    externalLinks = portfolioData.externalLinks,
                    onBackToTop = {
                        coroutineScope.launch {
                            listState.animateScrollToItem(0)
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun PortfolioBottomBar(
    currentSection: PortfolioSection,
    onSectionSelected: (PortfolioSection) -> Unit
) {
    NavigationBar(
        containerColor = DarkSurface,
        contentColor = TextSecondary
    ) {
        PortfolioSection.values().forEach { section ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = section.icon,
                        contentDescription = section.title
                    )
                },
                label = {
                    Text(
                        text = section.title,
                        style = MaterialTheme.typography.labelSmall
                    )
                },
                selected = currentSection == section,
                onClick = { onSectionSelected(section) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = PrimaryColor,
                    selectedTextColor = PrimaryColor,
                    unselectedIconColor = TextMuted,
                    unselectedTextColor = TextMuted,
                    indicatorColor = PrimaryColor.copy(alpha = 0.1f)
                )
            )
        }
    }
}
