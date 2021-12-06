package com.example.movieinfo.data.repository

import com.example.movieinfo.data.remote.OmdbApi
import com.example.movieinfo.data.remote.dto_search_response.DtoMovieSearchByName
import com.example.movieinfo.data.remote.dto_search_response.toMovieSearch
import com.example.movieinfo.domain.model.MovieSearch
import com.example.movieinfo.domain.repository.OmdbRepository
import javax.inject.Inject

class OmdbRepositoryImpl @Inject constructor(
    private val api: OmdbApi
) : OmdbRepository {
    override suspend fun getMovieBySearch(name: String): DtoMovieSearchByName {
        return api.getMovieBySearch(name = name)
    }
}