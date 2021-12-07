package com.example.movieinfo.domain.use_cases.use_case_get_movie_by_name

import com.example.movieinfo.core.Resource
import com.example.movieinfo.data.remote.OmdbApi
import com.example.movieinfo.data.remote.dto_search_response.toSearchByNameList
import com.example.movieinfo.data.remote.dto_title_response.toMovieSearch
import com.example.movieinfo.domain.model.MovieSearchByName
import com.example.movieinfo.domain.model.MovieSearchByTitle
import com.example.movieinfo.domain.repository.OmdbRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UseCaseGetMovieByName @Inject constructor(private val omdbRepository: OmdbRepository) {
    operator fun invoke(name: String): Flow<Resource<List<MovieSearchByName>>> = flow {
        try {
            emit(Resource.Loading<List<MovieSearchByName>>())
            val movie = omdbRepository.getMovieByName(name = name).toSearchByNameList()
            emit(Resource.Success<List<MovieSearchByName>>(data = movie))
        } catch (e: HttpException) {
            emit(Resource.Error<List<MovieSearchByName>>(message = e.toString()))
        } catch (e: IOException) {
            emit(Resource.Error<List<MovieSearchByName>>(message = e.toString()))
        } catch (e: Exception) {
            emit(
                Resource.Error<List<MovieSearchByName>>(
                    message = e.localizedMessage ?: "An error occurred"
                )
            )
        }
    }
}