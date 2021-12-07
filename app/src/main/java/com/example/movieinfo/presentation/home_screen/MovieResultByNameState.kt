package com.example.movieinfo.presentation.home_screen

import com.example.movieinfo.domain.model.MovieSearchByName
import com.example.movieinfo.domain.use_cases.use_case_get_movie_by_name.UseCaseGetMovieByName

data class MovieResultByNameState(
    val isLoading : Boolean = false,
    val error: String = "",
    val movieByName: List<MovieSearchByName> = listOf(MovieSearchByName()),
    val isLoaded : Boolean = false
)
