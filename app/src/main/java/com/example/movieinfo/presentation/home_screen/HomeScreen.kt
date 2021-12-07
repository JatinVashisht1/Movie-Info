package com.example.movieinfo.presentation.home_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.movieinfo.presentation.home_screen.components.CustomTextField
import com.example.movieinfo.presentation.home_screen.components.ListMovieSearchByName

@ExperimentalComposeUiApi
@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val result = viewModel.resultByTitle.value
    val text = viewModel.searchTerm.value

    val titleResult = viewModel.resultByName.value

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (titleResult.error.isNotBlank()) {
            Text(
                text = result.error,
                modifier = Modifier.align(Alignment.Center),
                color = Color.Red
            )
        }
        if (titleResult.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            CustomTextField(
                text = text,
                modifier = Modifier.fillMaxWidth(),
                viewModel = viewModel
            ) {
                viewModel.searchTerm.value = it
            }
            if (titleResult.isLoaded) {
                ListMovieSearchByName(
                    movieSearchList = titleResult.movieByName,
                    navController = navController
                )
            }
        }

    }
}
