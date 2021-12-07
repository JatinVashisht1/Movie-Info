package com.example.movieinfo.presentation.movie_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movieinfo.presentation.home_screen.components.MovieDetails
import com.example.movieinfo.presentation.home_screen.components.MovieImage
import kotlinx.coroutines.Dispatchers.IO

@Composable
fun MovieDetailScreen(
    imdbId: String,
    viewModel: MovieDetailViewModel = hiltViewModel()
) {
    viewModel.imdbId.value = imdbId
    LaunchedEffect(IO) {
        viewModel.getMovieResult(imdbId)
    }
    val result = viewModel.resultByTitle.value
    val listState = rememberLazyListState()
    Box(modifier = Modifier.fillMaxSize()) {
        if (result.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        if (result.error.isNotBlank()) {
            Text(
                text = result.error,
                color = Color.Red,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        LazyColumn(state = listState, modifier = Modifier.fillMaxSize()) {
            item(1) {
                if (result.isLoaded) {
                    MovieImage(
                        url = result.movieByTitle.poster,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .padding(8.dp)
                    )

                    MovieDetails(
                        movieSearchByTitle = result.movieByTitle,
                        modifier = Modifier
                            .fillMaxWidth()
//                        .fillMaxHeight()
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}