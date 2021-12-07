package com.example.movieinfo.presentation.home_screen.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.rememberImagePainter
import com.example.movieinfo.R

@Composable
fun MovieImage(
    url: String?,
    modifier: Modifier = Modifier
) {
    Image(
        painter = rememberImagePainter(url, builder = {
            crossfade(true)
            placeholder(R.drawable.ic_image)
        }),
        contentDescription = null,
        modifier = modifier

    )
}