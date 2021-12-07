package com.example.movieinfo.data.remote

import com.example.movieinfo.data.remote.dto_search_response.DtoSearchResponse
import com.example.movieinfo.data.remote.dto_title_response.DtoMovieSearchByTitle
import retrofit2.http.GET
import retrofit2.http.Query

interface OmdbApi {
    @GET("?")
    suspend fun getMovieByTitle(
        @Query ("i") name: String,
        @Query("plot") plot: String = "full",
        @Query("apiKey") apiKey: String = "7232bc52"
    ) : DtoMovieSearchByTitle

    @GET("?")
    suspend fun getMovieBySearch(
        @Query ("s") name: String,
        @Query ("apiKey") apiKey: String = "7232bc52",
    ) : DtoSearchResponse
}