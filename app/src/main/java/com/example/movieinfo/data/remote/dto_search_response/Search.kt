package com.example.movieinfo.data.remote.dto_search_response


import com.example.movieinfo.domain.model.MovieSearchByName
import com.google.gson.annotations.SerializedName

data class Search(
    @SerializedName("imdbID")
    val imdbID: String = "",
    @SerializedName("Poster")
    val poster: String = "",
    @SerializedName("Title")
    val title: String = "",
    @SerializedName("Type")
    val type: String = "",
    @SerializedName("Year")
    val year: String = ""
)

fun Search.toMovieSearchByName () = MovieSearchByName(
    title = title,
    year = year,
    type = type,
    poster = poster,
    imdbId = imdbID
)