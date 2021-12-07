package com.example.movieinfo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieinfo.presentation.home_screen.HomeScreen
import com.example.movieinfo.presentation.movie_detail.MovieDetailScreen
import com.example.movieinfo.presentation.ui.theme.MovieInfoTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieInfoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController: NavHostController = rememberNavController()
                    val scope = rememberCoroutineScope()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.HomeScreen.route
                    ) {
                        composable(route = Screen.HomeScreen.route) {
                            HomeScreen(navController = navController)
                        }
                        composable(route = Screen.DetailScreen.route + "/{imdbId}",
                            arguments = listOf(navArgument("imdbId"){type = NavType.StringType})
                            ){
                            MovieDetailScreen(imdbId = it.arguments?.getString("imdbId")!!)
                        }
                    }
                }
            }
        }
    }
}