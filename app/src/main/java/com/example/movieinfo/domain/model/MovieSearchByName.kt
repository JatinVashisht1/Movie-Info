package com.example.movieinfo.domain.model

data class MovieSearchByName(
    val title: String = "",
    val year: String = "",
    val type: String = "",
    val poster: String = "",
    val imdbId: String = ""
)
