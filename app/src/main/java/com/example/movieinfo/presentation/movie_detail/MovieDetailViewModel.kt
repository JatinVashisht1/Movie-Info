package com.example.movieinfo.presentation.movie_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieinfo.core.Resource
import com.example.movieinfo.domain.use_cases.use_case_get_movie_by_title.UseCaseGetMovieByTitle
import com.example.movieinfo.presentation.home_screen.MovieResultByTitleState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieBySearchUseCase: UseCaseGetMovieByTitle,
) : ViewModel() {
    val imdbId = mutableStateOf<String>("")
    private val _result = mutableStateOf<MovieResultByTitleState>(MovieResultByTitleState())
    val resultByTitle: State<MovieResultByTitleState> = _result


    suspend fun getMovieResult(name:String = imdbId.value) {
        getMovieBySearchUseCase(name = name).onEach {res->
            when(res){
                is Resource.Success -> {
                    _result.value = res.data?.let { MovieResultByTitleState(movieByTitle = it, isLoaded = true) }!!
                }
                is Resource.Error ->{
                    _result.value = MovieResultByTitleState(error = res.message!!)
                }
                is Resource.Loading -> {
                    _result.value = MovieResultByTitleState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}