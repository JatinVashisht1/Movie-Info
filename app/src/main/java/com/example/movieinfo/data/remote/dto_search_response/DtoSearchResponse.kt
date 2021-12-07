package com.example.movieinfo.data.remote.dto_search_response


import com.example.movieinfo.domain.model.MovieSearchByName
import com.google.gson.annotations.SerializedName

data class DtoSearchResponse(
    @SerializedName("Response")
    val response: String = "",
    @SerializedName("Search")
    val search: List<Search> = listOf(),
    @SerializedName("totalResults")
    val totalResults: String = ""
)

fun DtoSearchResponse.toSearchByNameList() = search.map { it.toMovieSearchByName() }