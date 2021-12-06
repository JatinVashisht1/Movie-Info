package com.example.movieinfo.domain.use_cases.use_case_get_movie_by_search

import com.example.movieinfo.core.Resource
import com.example.movieinfo.data.remote.dto_search_response.toMovieSearch
import com.example.movieinfo.domain.model.MovieSearch
import com.example.movieinfo.domain.repository.OmdbRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UseCaseGetMovieBySearch @Inject constructor(
    private val omdbRepository: OmdbRepository
) {
    operator fun invoke (name: String) : Flow<Resource<MovieSearch>> = flow {
        try {
            emit(Resource.Loading<MovieSearch>())
            val movie = omdbRepository.getMovieBySearch(name = name).toMovieSearch()
            emit(Resource.Success<MovieSearch>(data = movie))
        }catch (e: HttpException){
            emit(Resource.Error<MovieSearch>(message = e.toString()))
        }
        catch (e: IOException){
            emit(Resource.Error<MovieSearch>(message = e.toString()))
        }
        catch (e: Exception){
            emit(Resource.Error<MovieSearch>(message = e.localizedMessage?: "An error occurred"))
        }
    }
}