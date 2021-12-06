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
import com.example.movieinfo.presentation.home_screen.components.CustomTextField

@ExperimentalComposeUiApi
@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val result = viewModel.result.value
    val text = viewModel.searchTerm.value
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        CustomTextField(text = text,modifier = Modifier.fillMaxWidth(), viewModel = viewModel){
            viewModel.searchTerm.value = it
        }

        if(result.error.isNotBlank()){
            Text(text = result.error, modifier = Modifier.align(Alignment.CenterHorizontally), color = Color.Red)
        }
        if(result.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        }
        Text(result.news.plot, modifier = Modifier
            .align(Alignment.Start)
            .padding(8.dp)
        )
    }
}