package com.example.movieinfo.data.repository

import com.example.movieinfo.data.remote.OmdbApi
import com.example.movieinfo.data.remote.dto_search_response.DtoSearchResponse
import com.example.movieinfo.data.remote.dto_title_response.DtoMovieSearchByTitle
import com.example.movieinfo.domain.repository.OmdbRepository
import javax.inject.Inject

class OmdbRepositoryImpl @Inject constructor(
    private val api: OmdbApi
) : OmdbRepository {
    override suspend fun getMovieByTitle(name: String): DtoMovieSearchByTitle {
        return api.getMovieByTitle(name = name)
    }

    override suspend fun getMovieByName(name: String): DtoSearchResponse {
        return api.getMovieBySearch(name = name)
    }
}