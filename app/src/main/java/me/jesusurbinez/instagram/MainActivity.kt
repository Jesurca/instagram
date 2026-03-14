package me.jesusurbinez.instagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import me.jesusurbinez.instagram.ui.screens.FeedScreen
import me.jesusurbinez.instagram.ui.theme.InstagramTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramTheme {
                FeedScreen()
            }
        }
    }
}
