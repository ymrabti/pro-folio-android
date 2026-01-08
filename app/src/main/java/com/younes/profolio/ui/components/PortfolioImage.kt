package com.younes.profolio.ui.components

import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage

@Composable
fun PortfolioImage(
    source: String,
    modifier: Modifier,
    contentScale: ContentScale
) {
    val context = LocalContext.current
    if (source.startsWith("res://")) {
        val name = source.removePrefix("res://")
        val resId = context.resources.getIdentifier(name, "drawable", context.packageName)
        if (resId != 0) {
            Image(
                painter = painterResource(id = resId),
                contentDescription = name,
                modifier = modifier,
                contentScale = contentScale
            )
            return
        }
    }
    // Fallback to remote/other sources
    AsyncImage(
        model = source,
        contentDescription = null,
        modifier = modifier,
        contentScale = contentScale
    )
}
