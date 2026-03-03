package com.ymrabtiapps.portfolio.data.repository

import com.ymrabtiapps.portfolio.data.model.*

/**
 * Repository providing all portfolio data
 */
object PortfolioRepository {

    val portfolioData: PortfolioData by lazy {
        PortfolioData(
            personalInfo = personalInfo,
            skills = skills,
            projects = projects,
            professionalContributions = professionalContributions,
            educations = educations,
            externalLinks = externalLinks
        )
    }

    val personalInfo = PersonalInfo(
        name = "Younes MRABTI",
        tagline = "Serving the code community",
        description = "Full Stack Developer & GIS Specialist with expertise in modern web technologies, mobile development, and geospatial solutions. Passionate about creating innovative platforms and contributing to the developer community.",
        avatarUrl = "https://www.youmti.net/assets/images/avatar.webp",
        location = "Morocco",
        email = "admin@youmrabti.com"
    )

    val skills = listOf(
        // Dev Skills
        Skill(name = "Dart/Flutter", level = 95, category = SkillCategory.DEV, icon = "flutter"),
        Skill(name = "JavaScript/Node.js/React", level = 90, category = SkillCategory.DEV, icon = "javascript"),
        Skill(name = "TypeScript/Angular/NestJS", level = 95, category = SkillCategory.DEV, icon = "angular"),
        Skill(name = "C#/.NET", level = 85, category = SkillCategory.DEV, icon = "dotnet"),
        Skill(name = "Java", level = 80, category = SkillCategory.DEV, icon = "java"),
        Skill(name = "Kotlin/Android", level = 85, category = SkillCategory.DEV, icon = "android"),
        Skill(name = "Swift/iOS", level = 75, category = SkillCategory.DEV, icon = "swift"),

        // Ops Skills
        Skill(name = "Docker", level = 85, category = SkillCategory.OPS, icon = "docker"),
        Skill(name = "Reverse Proxy/Cloudflare", level = 80, category = SkillCategory.OPS, icon = "cloudflare"),
        Skill(name = "VibeCoding", level = 90, category = SkillCategory.OPS, icon = "code"),

        // Database Skills
        Skill(name = "PostgreSQL", level = 90, category = SkillCategory.DATABASE, icon = "postgresql"),
        Skill(name = "SQL Server", level = 85, category = SkillCategory.DATABASE, icon = "sql-server"),
        Skill(name = "MySQL", level = 85, category = SkillCategory.DATABASE, icon = "mysql"),
        Skill(name = "MongoDB", level = 90, category = SkillCategory.DATABASE, icon = "mongodb"),

        // GIS Skills
        Skill(name = "ArcGIS Online", level = 95, category = SkillCategory.GIS, icon = "arcgis"),
        Skill(name = "ArcGIS Enterprise", level = 90, category = SkillCategory.GIS, icon = "arcgis"),
        Skill(name = "ArcGIS Developers", level = 95, category = SkillCategory.GIS, icon = "arcgis-dev"),
        Skill(name = "QGIS", level = 85, category = SkillCategory.GIS, icon = "qgis"),

        // IDE Skills
        Skill(name = "VSCode", level = 95, category = SkillCategory.IDE, icon = "vscode"),
        Skill(name = "IntelliJ", level = 85, category = SkillCategory.IDE, icon = "intellij"),
        Skill(name = "XCode", level = 80, category = SkillCategory.IDE, icon = "xcode")
    )

    private val projects = listOf(
        // FullStack Platforms
        Project(
            id = "apple-health",
            title = "AppleHealth",
            description = "Health social platform where users share Apple Health export data analysis and personal health dashboards (steps, running/walking distance, calories, exercise minutes)",
            category = ProjectCategory.FULLSTACK,
            status = ProjectStatus.COMPLETED,
            liveUrl = "https://healthy.youmrabti.com/",
            githubUrl = "https://github.com/ymrabti/apple_health_ng",
            imageUrl = "https://www.youmti.net/assets/images/full-stack/apple_health.webp",
            features = listOf(
                ProjectFeature(
                    title = "Data Processing",
                    description = "Secure script that reads and interprets Apple Health data",
                    technologies = listOf(
                        Technology(name = "Python", icon = "python"),
                        Technology(name = "Data Analysis", icon = "analytics")
                    )
                ),
                ProjectFeature(
                    title = "Backend & Database",
                    description = "Health data management and secure server communication",
                    technologies = listOf(
                        Technology(name = "Node.js", icon = "nodejs"),
                        Technology(name = "Express", icon = "express"),
                        Technology(name = "PostgreSQL", icon = "postgresql")
                    )
                ),
                ProjectFeature(
                    title = "Frontend Dashboard",
                    description = "Personal health dashboard and social sharing features",
                    technologies = listOf(Technology(name = "Angular", icon = "angular"))
                )
            )
        ),
        Project(
            id = "presence-flow",
            title = "Presence flow with QR Codes",
            description = "Platform for check-in presence/leave of employees, students, business staff, stores via short temporary QR codes shown dynamically",
            category = ProjectCategory.FULLSTACK,
            status = ProjectStatus.ONGOING,
            imageUrl = "https://www.youmti.net/assets/images/full-stack/presence_flow.webp",
            liveUrl = "https://qrchecks.youmrabti.com",
            features = listOf(
                ProjectFeature(
                    title = "Backend/Database",
                    description = "Real-time QR code management and validation system",
                    technologies = listOf(
                        Technology(name = "Node.js", icon = "nodejs"),
                        Technology(name = "Express", icon = "express"),
                        Technology(name = "MySQL", icon = "mysql"),
                        Technology(name = "Socket.io", icon = "socketio")
                    )
                ),
                ProjectFeature(
                    title = "Mobile App",
                    description = "Two user types: Gates show QR codes, users scan QR codes",
                    technologies = listOf(
                        Technology(name = "Dart", icon = "dart"),
                        Technology(name = "Flutter", icon = "flutter")
                    )
                ),
                ProjectFeature(
                    title = "Backoffice",
                    description = "Statistics, configurations, absence justification/confirming, reporting",
                    technologies = listOf(
                        Technology(name = "TypeScript", icon = "typescript"),
                        Technology(name = "Angular", icon = "angular")
                    )
                )
            )
        ),
        Project(
            id = "chatup",
            title = "ChatUp",
            description = "Modern end-to-end encryption chat application supporting group chats and file sharing",
            category = ProjectCategory.FULLSTACK,
            status = ProjectStatus.ONGOING,
            liveUrl = "https://chat-up.youmrabti.com/",
            imageUrl = "https://www.youmti.net/assets/images/full-stack/chatup.webp",
            features = listOf(
                ProjectFeature(
                    title = "Backend/Database",
                    description = "Secure messaging infrastructure with real-time capabilities",
                    technologies = listOf(
                        Technology(name = "JavaScript", icon = "javascript"),
                        Technology(name = "Node.js", icon = "nodejs"),
                        Technology(name = "MongoDB", icon = "mongodb")
                    )
                ),
                ProjectFeature(
                    title = "Mobile App",
                    description = "End-to-end encryption with X25519, secure storage, IndexedDB",
                    technologies = listOf(
                        Technology(name = "Dart", icon = "dart"),
                        Technology(name = "Flutter", icon = "flutter"),
                        Technology(name = "X25519 Encryption", icon = "security"),
                        Technology(name = "Cryptography", icon = "security")
                    )
                ),
                ProjectFeature(
                    title = "Presentation",
                    description = "App description, releases, email verification and reset password callbacks",
                    technologies = listOf(
                        Technology(name = "Web Technologies", icon = "web")
                    )
                )
            )
        ),
        Project(
            id = "pharmacie-de-garde",
            title = "Pharmacie de Garde Morocco",
            description = "Web platform for locating on-duty pharmacies in Morocco with geolocation and search features",
            category = ProjectCategory.FULLSTACK,
            status = ProjectStatus.PLANNED,
            imageUrl = "https://www.youmti.net/assets/images/full-stack/pharmacie_de_garde.webp",
            technologies = listOf(
                Technology(name = "Next.js", icon = "nextjs"),
                Technology(name = "TypeScript", icon = "typescript"),
                Technology(name = "PostgreSQL", icon = "postgresql")
            ),
            features = emptyList()
        ),
        Project(
            id = "streetview-xeno",
            title = "StreetViewXeno",
            description = "360° images viewer platform based on Krpano viewer with timeline, map integration, directional hotspots, and XLSX mass upload system",
            category = ProjectCategory.FULLSTACK,
            status = ProjectStatus.COMPLETED,
            liveUrl = "https://streetview_client.youmrabti.com/",
            imageUrl = "https://www.youmti.net/assets/images/full-stack/streetview.webp",
            technologies = listOf(
                Technology(name = "Krpano", icon = "panorama"),
                Technology(name = "JavaScript", icon = "javascript"),
                Technology(name = "XLSX", icon = "excel")
            ),
            features = listOf(
                ProjectFeature(
                    title = "Viewer Platform",
                    description = "360° visualization with timeline and map containing related spots",
                    technologies = listOf(
                        Technology(name = "Krpano", icon = "panorama"),
                        Technology(name = "Web Technologies", icon = "web")
                    )
                ),
                ProjectFeature(
                    title = "Upload System",
                    description = "XLSX images uploader with custom generator and multiresolution converter",
                    technologies = listOf(
                        Technology(name = "Image Processing", icon = "image"),
                        Technology(name = "XLSX Generator", icon = "excel")
                    )
                ),
                ProjectFeature(
                    title = "Advanced Features",
                    description = "Directional hotspots and mass images upload with conversion",
                    technologies = listOf(
                        Technology(name = "Image Converter", icon = "transform"),
                        Technology(name = "Krpano Integration", icon = "integration")
                    )
                )
            )
        ),
        // Mobile Apps
        Project(
            id = "botola-max",
            title = "BotolaMax",
            description = "Mobile application for football matches, competitions, and results with comprehensive statistics",
            category = ProjectCategory.MOBILE,
            status = ProjectStatus.COMPLETED,
            imageUrl = "https://www.youmti.net/assets/images/mobile/botola_max.webp",
            features = listOf(
                ProjectFeature(
                    title = "Football Data Management",
                    description = "Live matches, competitions, and relevant statistics",
                    technologies = listOf(
                        Technology(name = "Flutter", icon = "flutter"),
                        Technology(name = "Sports APIs", icon = "sports"),
                        Technology(name = "Data Analytics", icon = "analytics")
                    )
                )
            )
        ),
        Project(
            id = "luxmap",
            title = "LuxMap",
            description = "Mobile tool for collection of lux light data with geolocation, handles XLSX exports for analysis",
            category = ProjectCategory.MOBILE,
            status = ProjectStatus.COMPLETED,
            playStoreUrl = "https://play.google.com/store/apps/details?id=com.ymrabtiapps.geoligtmeter",
            imageUrl = "https://www.youmti.net/assets/images/mobile/luxmap.webp",
            features = listOf(
                ProjectFeature(
                    title = "Light & Location Data",
                    description = "Lux data collection with precise GPS coordinates",
                    technologies = listOf(
                        Technology(name = "Flutter", icon = "flutter"),
                        Technology(name = "Light Sensors", icon = "sensor"),
                        Technology(name = "GPS/Geolocation", icon = "location"),
                        Technology(name = "XLSX Export", icon = "excel")
                    )
                )
            )
        ),
        Project(
            id = "thumbhub",
            title = "ThumbHub",
            description = "A Flutter app for fetching, previewing, and downloading YouTube video thumbnails in multiple resolutions.",
            category = ProjectCategory.MOBILE,
            status = ProjectStatus.ONGOING,
            playStoreUrl = "https://play.google.com/store/apps/details?id=com.ymrabtiapps.thumbnails.thumbnail_youtube",
            imageUrl = "https://www.youmti.net/assets/images/mobile/thumbhub.webp",
            features = listOf(
                ProjectFeature(
                    title = "YouTube Thumbnails",
                    description = "Fetch, preview, and download YouTube video thumbnails in multiple resolutions",
                    technologies = listOf(
                        Technology(name = "Flutter", icon = "flutter"),
                        Technology(name = "Firebase", icon = "database"),
                        Technology(name = "Business Logic", icon = "business")
                    )
                )
            )
        ),
        // Development Tools
        Project(
            id = "power-geojson",
            title = "PowerGeoJSON",
            description = "Powerful tool for GeoJSON with flutter_map, styled from properties, supports Esri JSON, soon supports multiple projections",
            category = ProjectCategory.TOOL,
            status = ProjectStatus.COMPLETED,
            githubUrl = "https://github.com/youmtinetflutterpacks/power_geojson",
            liveUrl = "https://pub.dev/packages/power_geojson",
            imageUrl = "https://www.youmti.net/assets/images/tools/power_geojson.webp",
            features = listOf(
                ProjectFeature(
                    title = "Flutter Package (pub.dev)",
                    description = "Advanced GeoJSON processing with flutter_map integration",
                    technologies = listOf(
                        Technology(name = "Dart", icon = "dart"),
                        Technology(name = "Flutter", icon = "flutter"),
                        Technology(name = "GeoJSON", icon = "geojson"),
                        Technology(name = "Esri JSON", icon = "esri")
                    )
                )
            )
        ),
        Project(
            id = "flutter-azimuth",
            title = "Flutter Azimuth",
            description = "Flutter Compass Tools Implementation measuring azimuth angle between magnetic north and device orientation",
            category = ProjectCategory.TOOL,
            status = ProjectStatus.COMPLETED,
            imageUrl = "https://www.youmti.net/assets/images/tools/flutter_azimuth.webp",
            githubUrl = "https://github.com/youmtinetflutterpacks/flutter_azimuth",
            liveUrl = "https://pub.dev/packages/flutter_azimuth",
            features = listOf(
                ProjectFeature(
                    title = "Compass Plugin (pub.dev)",
                    description = "Precise azimuth measurement for navigation apps",
                    technologies = listOf(
                        Technology(name = "Flutter", icon = "flutter"),
                        Technology(name = "Compass Sensors", icon = "sensor"),
                        Technology(name = "Magnetometer", icon = "sensor")
                    )
                )
            )
        ),
        Project(
            id = "popup-menu-2",
            title = "Popup Menu 2",
            description = "Popup menu with clickable buttons and global click function to maintain user attention without breaking focus",
            category = ProjectCategory.TOOL,
            status = ProjectStatus.COMPLETED,
            imageUrl = "https://www.youmti.net/assets/images/tools/popup_menu_2.webp",
            githubUrl = "https://github.com/youmtinetflutterpacks/popup_menu_2",
            liveUrl = "https://pub.dev/packages/popup_menu_2",
            features = listOf(
                ProjectFeature(
                    title = "UI Component (pub.dev)",
                    description = "User-attention focused popup menu design",
                    technologies = listOf(
                        Technology(name = "Flutter", icon = "flutter"),
                        Technology(name = "UI/UX Design", icon = "design"),
                        Technology(name = "Dart", icon = "dart")
                    )
                )
            )
        ),
        Project(
            id = "json-dart-converter",
            title = "JSON to Dart Model Converter",
            description = "Online tool for converting JSON data structures to Dart model classes automatically",
            category = ProjectCategory.TOOL,
            status = ProjectStatus.COMPLETED,
            imageUrl = "https://www.youmti.net/assets/images/tools/dartify.webp",
            liveUrl = "https://open-vsx.org/extension/YOUMTINET/dartifyjson",
            githubUrl = "https://github.com/ymrabti/vscode-dartify",
            features = listOf(
                ProjectFeature(
                    title = "Code Generation Tool",
                    description = "Automated Dart model class generation from JSON",
                    technologies = listOf(
                        Technology(name = "JavaScript", icon = "javascript"),
                        Technology(name = "JSON Parser", icon = "json"),
                        Technology(name = "Code Generation", icon = "code")
                    )
                )
            )
        ),
        Project(
            id = "krpanos-tool",
            title = "Image 360° Converter",
            description = "Convert 360° images to multiresolution format with XLSX generator for StreetViewXeno integration",
            category = ProjectCategory.TOOL,
            status = ProjectStatus.COMPLETED,
            imageUrl = "https://www.youmti.net/assets/images/tools/krpanos-tool.webp",
            liveUrl = "https://www.npmjs.com/package/krpanos-tools",
            features = listOf(
                ProjectFeature(
                    title = "Image Processing Tool",
                    description = "Multiresolution conversion and XLSX generation for 360° platforms",
                    technologies = listOf(
                        Technology(name = "Image Processing", icon = "image"),
                        Technology(name = "XLSX Generation", icon = "excel"),
                        Technology(name = "Krpano Integration", icon = "integration")
                    )
                )
            )
        )
    )

    val professionalContributions = listOf(
        ProfessionalContribution(
            company = "Majal Berkane",
            role = "Mobile Developer & GIS Specialist",
            period = "01/2023 - Present",
            description = "IT & GIS Manager overseeing end-to-end geospatial solutions, including real-time mapping, spatial analysis, and dashboards. Led the full GIS data lifecycle and ArcGIS Online initiatives to deliver data-driven insights supporting urban development and digital citizen services.",
            projects = listOf(
                Project(
                    id = "find-tobissi",
                    title = "Find Tobissi",
                    description = "Mobile application for estimating bus arrival time and distance to improve public transportation experience",
                    category = ProjectCategory.PROFESSIONAL,
                    status = ProjectStatus.COMPLETED,
                    features = listOf(
                        ProjectFeature(
                            title = "Real-time Bus Tracking",
                            description = "GPS-based bus location tracking with accurate arrival time estimation",
                            technologies = listOf(
                                Technology(name = "Mobile Development", icon = "mobile"),
                                Technology(name = "GPS Tracking", icon = "location"),
                                Technology(name = "Real-time Data", icon = "real-time")
                            )
                        )
                    )
                ),
                Project(
                    id = "eco-geste",
                    title = "ÉCO-GESTE",
                    description = "Ecological awareness mobile application encouraging citizens to sort waste with reward points convertible to gifts, promoting environmental sustainability",
                    category = ProjectCategory.PROFESSIONAL,
                    status = ProjectStatus.COMPLETED,
                    features = listOf(
                        ProjectFeature(
                            title = "Gamification & Rewards",
                            description = "Point-based reward system for ecological behavior with gift conversion",
                            technologies = listOf(
                                Technology(name = "Mobile Development", icon = "mobile"),
                                Technology(name = "Gamification", icon = "game"),
                                Technology(name = "Reward System", icon = "reward")
                            )
                        )
                    )
                ),
                Project(
                    id = "borne-citoyenne",
                    title = "Borne Citoyenne",
                    description = "Citizen service application for Berkane commune measuring satisfaction levels and providing comprehensive service information to improve citizen engagement",
                    category = ProjectCategory.PROFESSIONAL,
                    status = ProjectStatus.COMPLETED,
                    features = listOf(
                        ProjectFeature(
                            title = "Citizen Services Platform",
                            description = "Satisfaction surveys, document consultation, and service information management",
                            technologies = listOf(
                                Technology(name = "Mobile Development", icon = "mobile"),
                                Technology(name = "Data Synchronization", icon = "sync"),
                                Technology(name = "Survey System", icon = "survey")
                            )
                        )
                    )
                )
            )
        ),
        ProfessionalContribution(
            company = "Marafik Berkane",
            role = "GIS Specialist",
            period = "06/2021 - 12/2022",
            description = "As a GIS Engineer at Marafik Berkane, I architected and delivered high-impact geospatial solutions, including real-time mapping systems, advanced spatial analytics, and precision distance measurement tools. I oversaw the full geospatial data lifecycle—from acquisition and modeling to governance and optimization—while leading ArcGIS Online initiatives and developing interactive dashboards to enhance operational visibility and decision-making. \n\nMy scope covered critical public services such as public transport networks, household waste management, green spaces and urban forestry (palms and trees), slaughterhouses, and their associated supply chains, ensuring data-driven governance and service performance optimization.",
            projects = emptyList()
        )
    )

    val educations = listOf(
        Education(
            institution = "École Hassania des travaux publics",
            degree = "Ingénieur d'État",
            field = "Science de l'information géographique",
            period = "09/2016 - 07/2020",
            location = "Casablanca",
            description = "Engineering degree in Geographic Information Science covering GIS technologies, spatial databases, remote sensing, and geospatial application development."
        ),
        Education(
            institution = "CPGE - Classes préparatoires aux grandes écoles d'ingénieurs",
            degree = "MPSI",
            field = "Mathématiques, Physique et Sciences de l'Ingénieur",
            period = "09/2014 - 06/2016",
            location = "Meknès",
            description = "Preparatory classes for engineering schools focusing on mathematics, physics, and engineering sciences."
        ),
        Education(
            institution = "Lycée Lalla Salma",
            degree = "Baccalauréat",
            field = "Sciences Mathématiques",
            period = "2014",
            location = "Rissani",
            description = "High school diploma with focus on mathematics and sciences."
        )
    )

    val externalLinks = listOf(
        ExternalLink(
            platform = "GitHub - Main Profile",
            url = "https://github.com/ymrabti",
            icon = "github",
            description = "Main repositories and contributions"
        ),
        ExternalLink(
            platform = "GitHub - Flutter Packages",
            url = "https://github.com/youmtinetflutterpacks",
            icon = "github",
            description = "Organization for Flutter packages"
        ),
        ExternalLink(
            platform = "GitHub - Flutter Apps",
            url = "https://github.com/youmtinet-flutter-apps",
            icon = "github",
            description = "Organization for Flutter applications"
        ),
        ExternalLink(
            platform = "LinkedIn",
            url = "https://linkedin.com/in/younesmrabti1996",
            icon = "linkedin",
            description = "Professional network and updates"
        ),
        ExternalLink(
            platform = "Patreon",
            url = "https://patreon.com/youmrabti",
            icon = "patreon",
            description = "Support my open source work"
        )
    )

    fun getSkillsByCategory(category: SkillCategory): List<Skill> {
        return skills.filter { it.category == category }
    }

    fun getProjectsByCategory(category: ProjectCategory): List<Project> {
        return projects.filter { it.category == category }
    }
}
