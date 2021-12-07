package com.example.movieinfo.presentation.home_screen

import com.example.movieinfo.domain.model.MovieSearchByTitle

data class MovieResultByTitleState(
    val isLoading: Boolean = false,
    val movieByTitle: MovieSearchByTitle = MovieSearchByTitle(),
    val error: String = "",
    val isLoaded : Boolean = false
)
