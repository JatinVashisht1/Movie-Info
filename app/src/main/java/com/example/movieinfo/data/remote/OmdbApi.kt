package com.example.movieinfo.data.remote

import com.example.movieinfo.data.remote.dto_search_response.DtoMovieSearchByName
import retrofit2.http.GET
import retrofit2.http.Query

interface OmdbApi {
    @GET("?")
    suspend fun getMovieBySearch(
        @Query ("t") name: String,
        @Query("plot") plot: String = "full",
        @Query("apiKey") apiKey: String = "7232bc52"
    ) : DtoMovieSearchByName
}