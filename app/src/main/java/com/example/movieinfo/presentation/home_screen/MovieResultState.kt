package com.example.movieinfo.presentation.home_screen

import com.example.movieinfo.domain.model.MovieSearch

data class MovieResultState(
    val isLoading: Boolean = false,
    val news: MovieSearch = MovieSearch(),
    val error: String = ""
)
