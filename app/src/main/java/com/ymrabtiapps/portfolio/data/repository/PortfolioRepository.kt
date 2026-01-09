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
            externalLinks = externalLinks
        )
    }

    val personalInfo = PersonalInfo(
        name = "Younes MRABTI",
        tagline = "Serving the code community",
        description = "Full Stack Developer & GIS Specialist with expertise in modern web technologies, mobile development, and geospatial solutions. Passionate about creating innovative platforms and contributing to the developer community.",
        avatarUrl = "https://avatars.githubusercontent.com/ymrabti",
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
            id = "qr-checks",
            title = "Presence flow with QR Codes",
            description = "Platform for check-in presence/leave of employees, students, business staff, stores via short temporary QR codes shown dynamically",
            category = ProjectCategory.FULLSTACK,
            status = ProjectStatus.ONGOING,
            imageUrl = "res://presence_flow",
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
            imageUrl = "res://chatup",
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
            status = ProjectStatus.ONGOING,
            imageUrl = "res://pharmacie_de_garde",
            technologies = listOf(
                Technology(name = "Next.js", icon = "nextjs"),
                Technology(name = "TypeScript", icon = "typescript"),
                Technology(name = "PostgreSQL", icon = "postgresql")
            ),
            features = emptyList()
        ),
        Project(
            id = "rifq",
            title = "RIFQ",
            description = "RIFQ is a national digital platform for the identification, monitoring, and humane management of domestic and stray animals, supporting public health, animal welfare, and data-driven territorial governance.",
            category = ProjectCategory.FULLSTACK,
            status = ProjectStatus.PLANNED,
            imageUrl = "res://rifq",
            features = emptyList()
        ),
        Project(
            id = "apple-health",
            title = "AppleHealth",
            description = "Health social platform where users share Apple Health export data analysis and personal health dashboards (steps, running/walking distance, calories, exercise minutes)",
            category = ProjectCategory.FULLSTACK,
            status = ProjectStatus.COMPLETED,
            liveUrl = "https://healthy.youmrabti.com/",
            githubUrl = "https://github.com/ymrabti/apple_health_ng",
            imageUrl = "res://apple_health",
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
            id = "streetview-xeno",
            title = "StreetViewXeno",
            description = "360° images viewer platform based on Krpano viewer with timeline, map integration, directional hotspots, and XLSX mass upload system",
            category = ProjectCategory.FULLSTACK,
            status = ProjectStatus.COMPLETED,
            liveUrl = "https://streetview_client.youmrabti.com/",
            imageUrl = "res://streetview",
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
            imageUrl = "res://botola_max",
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
            id = "geolight-meter",
            title = "Geolight Meter",
            description = "Mobile tool for collection of lux light data with geolocation, handles XLSX exports for analysis",
            category = ProjectCategory.MOBILE,
            status = ProjectStatus.COMPLETED,
            playStoreUrl = "https://play.google.com/store/apps/details?id=com.ymrabtiapps.geoligtmeter",
            imageUrl = "res://geolight_meter",
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
            id = "pharmagest",
            title = "Pharmagest",
            description = "Pharmacy management mobile application for inventory, sales, and customer management (ongoing)",
            category = ProjectCategory.MOBILE,
            status = ProjectStatus.ONGOING,
            playStoreUrl = "https://play.google.com/store/apps/details?id=com.ymrabtiapps.pharmagest",
            imageUrl = "res://pharmagest",
            features = listOf(
                ProjectFeature(
                    title = "Pharmacy Management",
                    description = "Complete pharmacy operations and inventory management",
                    technologies = listOf(
                        Technology(name = "Flutter", icon = "flutter"),
                        Technology(name = "Database Management", icon = "database"),
                        Technology(name = "Business Logic", icon = "business")
                    )
                )
            )
        ),
        // Development Tools
        Project(
            id = "portfolio-website",
            title = "Portfolio Website",
            description = "This stunning Angular portfolio showcasing skills, projects, and professional experience",
            category = ProjectCategory.TOOL,
            status = ProjectStatus.COMPLETED,
            imageUrl = "https://avatars.githubusercontent.com/ymrabti",
            liveUrl = "https://youmrabti.com",
            features = listOf(
                ProjectFeature(
                    title = "Modern Portfolio",
                    description = "Comprehensive showcase of expertise and experience",
                    technologies = listOf(
                        Technology(name = "Angular", icon = "angular"),
                        Technology(name = "TypeScript", icon = "typescript"),
                        Technology(name = "GSAP Animations", icon = "animation")
                    )
                )
            )
        ),
        Project(
            id = "svg-playground",
            title = "SVG Playground",
            description = "Create stunning SVG graphics with free online generator. Design polygons, stars, spirals, and curved shapes with real-time preview. Export as SVG or PNG.",
            category = ProjectCategory.TOOL,
            status = ProjectStatus.COMPLETED,
            githubUrl = "https://github.com/ymrabti/svg-playground",
            liveUrl = "https://svg-playground.youmrabti.com",
            imageUrl = "res://svg_playground",
            features = listOf(
                ProjectFeature(
                    title = "SVG Creation Tool",
                    description = "Real-time SVG generation with multiple shape types",
                    technologies = listOf(
                        Technology(name = "JavaScript", icon = "javascript"),
                        Technology(name = "SVG", icon = "svg"),
                        Technology(name = "Canvas", icon = "canvas")
                    )
                )
            )
        ),
        Project(
            id = "power-geojson",
            title = "PowerGeoJSON",
            description = "Powerful tool for GeoJSON with flutter_map, styled from properties, supports Esri JSON, soon supports multiple projections",
            category = ProjectCategory.TOOL,
            status = ProjectStatus.COMPLETED,
            githubUrl = "https://github.com/youmtinetflutterpacks/power_geojson",
            liveUrl = "https://pub.dev/packages/power_geojson",
            imageUrl = "res://power_geojson",
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
            id = "image-360-converter",
            title = "Image 360° Converter",
            description = "Convert 360° images to multiresolution format with XLSX generator for StreetViewXeno integration",
            category = ProjectCategory.TOOL,
            status = ProjectStatus.COMPLETED,
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
        ),
        Project(
            id = "soil-moisture-fetcher",
            title = "Soil Moisture Fetcher",
            description = "Automated soil moisture monitoring system using satellite remote sensing data from Sentinel-1 and NASA SMAP for precision agriculture",
            category = ProjectCategory.TOOL,
            status = ProjectStatus.COMPLETED,
            githubUrl = "https://github.com/ymrabti/soil-moisture-fetcher",
            features = listOf(
                ProjectFeature(
                    title = "Satellite Data Processing",
                    description = "Daily imagery retrieval, moisture maps generation, GeoTIFF/JPEG exports",
                    technologies = listOf(
                        Technology(name = "Python", icon = "python"),
                        Technology(name = "Google Earth Engine", icon = "earth-engine"),
                        Technology(name = "Docker", icon = "docker"),
                        Technology(name = "PostgreSQL", icon = "postgresql")
                    )
                ),
                ProjectFeature(
                    title = "Automated Monitoring",
                    description = "Real-time tracking with notifications for smart irrigation and environmental research",
                    technologies = listOf(
                        Technology(name = "Sentinel-1", icon = "satellite"),
                        Technology(name = "NASA SMAP", icon = "satellite"),
                        Technology(name = "Automation", icon = "automation")
                    )
                )
            )
        ),
        Project(
            id = "pc-cleaner",
            title = "Automatic PC Cleaner",
            description = "Automated Windows system maintenance script running weekly to clean temp files, clear caches, empty Recycle Bin, and optimize disk space",
            category = ProjectCategory.TOOL,
            status = ProjectStatus.COMPLETED,
            features = listOf(
                ProjectFeature(
                    title = "System Maintenance",
                    description = "Hands-free system optimization with automated logging and email reporting",
                    technologies = listOf(
                        Technology(name = "PowerShell", icon = "powershell"),
                        Technology(name = "Task Scheduler", icon = "windows"),
                        Technology(name = "Email Automation", icon = "email")
                    )
                )
            )
        )
    )

    val professionalContributions = listOf(
        ProfessionalContribution(
            company = "Marafik/Majal Berkane",
            role = "Full Stack Developer & GIS Specialist",
            period = "2020 - Present",
            description = "Designed and delivered dynamic geospatial solutions, including real-time map generation, statistical analysis, and distance measurement. Managed the full data lifecycle—collection, conversion, cleaning, processing, analysis, and interoperability—using advanced GIS workflows. Led ArcGIS Online data collection initiatives and developed interactive dashboards to support urban development projects and enhance digital citizen services through innovative, data-driven solutions.",
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
