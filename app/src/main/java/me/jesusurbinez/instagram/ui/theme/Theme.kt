package me.jesusurbinez.instagram.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val InstagramColorScheme = lightColorScheme(
    primary = Color(0xFF405DE6),
    secondary = Color(0xFFE1306C),
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black
)

@Composable
fun InstagramTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = InstagramColorScheme,
        content = content
    )
}