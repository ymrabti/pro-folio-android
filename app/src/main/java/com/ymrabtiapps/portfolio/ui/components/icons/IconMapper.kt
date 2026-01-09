package com.ymrabtiapps.portfolio.ui.components.icons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon

private fun techImageVectorFor(key: String): ImageVector {
    return when (key.lowercase()) {
        // Web / Languages
        "javascript", "typescript", "code" -> Icons.Default.Code
        "nodejs", "express" -> Icons.Default.Terminal
        "angular" -> Icons.Default.ChangeCircle
        "dart", "flutter" -> Icons.Default.PhoneAndroid
        "java" -> Icons.Default.Coffee
        "swift" -> Icons.Default.Bolt
        "dotnet", "c#", "csharp" -> Icons.Default.IntegrationInstructions

        // Databases
        "mysql", "postgresql", "mongodb", "database" -> Icons.Default.Storage

        // GIS / Mapping
        "geojson", "esri", "earth-engine", "gis", "qgis", "arcgis", "arcgis-dev" -> Icons.Default.Public

        // Media / Graphics
        "svg", "canvas", "image", "panorama" -> Icons.Default.Image

        // DevOps / Cloud
        "docker", "cloud", "automation", "integration" -> Icons.Default.Cloud
        "socketio", "real-time" -> Icons.Default.Bolt

        // Mobile / Sensors
        "mobile", "android", "ios" -> Icons.Default.PhoneIphone
        "sensor", "magnetometer", "compass" -> Icons.Default.Sensors
        "location", "gps", "place" -> Icons.Default.Place

        // Business / Misc
        "excel", "xlsx" -> Icons.Default.TableView
        "security", "encryption" -> Icons.Default.Security
        "analytics" -> Icons.Default.Leaderboard
        "sports" -> Icons.Default.SportsSoccer
        "business" -> Icons.Default.Work
        "sync" -> Icons.Default.Sync
        "reward", "game" -> Icons.Default.EmojiEvents
        "windows", "powershell" -> Icons.Default.Terminal

        else -> Icons.Default.Extension
    }
}

@Composable
fun TechIcon(key: String, tint: Color, size: Dp = 16.dp) {
    Icon(
        imageVector = techImageVectorFor(key),
        contentDescription = key,
        tint = tint,
        modifier = Modifier
            .then(Modifier)
    )
}
