package com.younes.profolio.data.model

/**
 * Skill category types
 */
enum class SkillCategory(val displayName: String) {
    DEV("Development"),
    OPS("DevOps"),
    DATABASE("Databases"),
    GIS("GIS & Mapping"),
    IDE("Development Tools")
}

/**
 * Project category types
 */
enum class ProjectCategory(val displayName: String) {
    FULLSTACK("FullStack Platforms"),
    MOBILE("Mobile Applications"),
    TOOL("Development Tools"),
    PROFESSIONAL("Professional Work")
}

/**
 * Project status types
 */
enum class ProjectStatus(val displayName: String) {
    COMPLETED("Completed"),
    ONGOING("In Progress"),
    PLANNED("Planned")
}

/**
 * Skill model
 */
data class Skill(
    val name: String,
    val level: Int, // 0-100
    val category: SkillCategory,
    val icon: String? = null,
    val description: String? = null
)

/**
 * Technology used in projects
 */
data class Technology(
    val name: String,
    val icon: String? = null,
    val url: String? = null
)

/**
 * Feature of a project
 */
data class ProjectFeature(
    val title: String,
    val description: String,
    val technologies: List<Technology>
)

/**
 * Project model
 */
data class Project(
    val id: String,
    val title: String,
    val description: String,
    val category: ProjectCategory,
    val features: List<ProjectFeature>,
    val technologies: List<Technology> = emptyList(),
    val status: ProjectStatus,
    val imageUrl: String? = null,
    val githubUrl: String? = null,
    val liveUrl: String? = null,
    val playStoreUrl: String? = null,
    val appStoreUrl: String? = null
)

/**
 * Professional contribution/experience
 */
data class ProfessionalContribution(
    val company: String,
    val role: String,
    val period: String,
    val projects: List<Project>,
    val description: String
)

/**
 * External links (social media, etc.)
 */
data class ExternalLink(
    val platform: String,
    val url: String,
    val icon: String,
    val description: String
)

/**
 * Personal information
 */
data class PersonalInfo(
    val name: String,
    val tagline: String,
    val description: String,
    val avatarUrl: String,
    val location: String,
    val email: String
)

/**
 * Complete portfolio data
 */
data class PortfolioData(
    val personalInfo: PersonalInfo,
    val skills: List<Skill>,
    val projects: List<Project>,
    val professionalContributions: List<ProfessionalContribution>,
    val externalLinks: List<ExternalLink>
)
