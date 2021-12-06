package com.example.movieinfo.domain.repository

import com.example.movieinfo.data.remote.dto_search_response.DtoMovieSearchByName
import com.example.movieinfo.domain.model.MovieSearch

interface OmdbRepository {
    suspend fun getMovieBySearch(name: String) : DtoMovieSearchByName
}