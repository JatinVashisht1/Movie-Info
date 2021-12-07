package com.example.movieinfo.domain.repository

import com.example.movieinfo.data.remote.dto_search_response.DtoSearchResponse
import com.example.movieinfo.data.remote.dto_title_response.DtoMovieSearchByTitle

interface OmdbRepository {
    suspend fun getMovieByTitle(name: String) : DtoMovieSearchByTitle
    suspend fun getMovieByName (name: String) : DtoSearchResponse
}