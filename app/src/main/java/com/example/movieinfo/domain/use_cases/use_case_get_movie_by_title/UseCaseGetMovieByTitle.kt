package com.example.movieinfo.domain.use_cases.use_case_get_movie_by_title

import com.example.movieinfo.core.Resource
import com.example.movieinfo.data.remote.dto_title_response.toMovieSearch
import com.example.movieinfo.domain.model.MovieSearchByTitle
import com.example.movieinfo.domain.repository.OmdbRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UseCaseGetMovieByTitle @Inject constructor(
    private val omdbRepository: OmdbRepository
) {
    operator fun invoke (name: String) : Flow<Resource<MovieSearchByTitle>> = flow {
        try {
            emit(Resource.Loading<MovieSearchByTitle>())
            val movie = omdbRepository.getMovieByTitle(name = name).toMovieSearch()
            emit(Resource.Success<MovieSearchByTitle>(data = movie))
        }catch (e: HttpException){
            emit(Resource.Error<MovieSearchByTitle>(message = e.toString()))
        }
        catch (e: IOException){
            emit(Resource.Error<MovieSearchByTitle>(message = e.toString()))
        }
        catch (e: Exception){
            emit(Resource.Error<MovieSearchByTitle>(message = e.localizedMessage?: "An error occurred"))
        }
    }
}