package com.example.movieinfo.presentation.home_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.movieinfo.domain.model.MovieSearchByName
import com.example.movieinfo.presentation.Screen

@Composable
fun ListMovieSearchByName(
    movieSearchList: List<MovieSearchByName>,
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val lazyListState = rememberLazyListState()
    LazyColumn(state = lazyListState, modifier = modifier){
        items(movieSearchList){item->
            MovieSearchItem(item = item, modifier = Modifier.fillMaxWidth()
                .height(200.dp)
                .clickable { navController.navigate(Screen.DetailScreen.route + "/${item.imdbId}") }
                .padding(8.dp))
        }
    }
}