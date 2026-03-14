package me.jesusurbinez.instagram.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import me.jesusurbinez.instagram.data.DataSource
import me.jesusurbinez.instagram.ui.components.PostCard
import me.jesusurbinez.instagram.ui.components.StoriesRow

@Composable
fun FeedScreen() {
    val posts = remember { DataSource.getPosts() }
    val stories = remember { DataSource.getStories() }

    Scaffold(
        topBar = { InstagramTopBar() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            state = rememberLazyListState()
        ) {
            /* —— Las stories van como un item único dentro del LazyColumn —— */
            item(key = "stories_row") {
                StoriesRow(stories = stories)
                Divider()
            }

            /* —— Los posts se iteran con items —— */
            items(
                items = posts,
                key = { post -> post.id }
            ) { post ->
                PostCard(
                    post = post,
                    onLikeClick = { likedPost ->
                        // Aquí podrías registrar el like en un Log o mostrar un Toast
                        android.util.Log.d("Feed", "Like en: ${likedPost.username}")
                    }
                )
            }
        }
    }
}

/* —— TOP BAR estilo Instagram —— */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstagramTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Instagram",
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                fontFamily = FontFamily.Cursive
            )
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = androidx.compose.material.icons.Icons.Outlined.FavoriteBorder,
                    contentDescription = "Notificaciones"
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = androidx.compose.material.icons.Icons.Outlined.Send,
                    contentDescription = "Mensajes"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        )
    )
}
