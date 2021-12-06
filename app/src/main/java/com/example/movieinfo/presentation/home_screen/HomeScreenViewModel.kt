package com.example.movieinfo.presentation.home_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieinfo.core.Resource
import com.example.movieinfo.domain.model.MovieSearch
import com.example.movieinfo.domain.use_cases.use_case_get_movie_by_search.UseCaseGetMovieBySearch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel
@Inject constructor(
    private val getMovieBySearchUseCase: UseCaseGetMovieBySearch
) : ViewModel() {
    private val _result = mutableStateOf<MovieResultState>(MovieResultState())
    val result: State<MovieResultState> = _result

    val searchTerm = mutableStateOf<String>("")

    suspend fun getMovieResult(name: String) {
        getMovieBySearchUseCase(name = name).onEach {res->
            when(res){
                is Resource.Success -> {
                    _result.value = res.data?.let { MovieResultState(news = it) }!!
                }
                is Resource.Error ->{
                    _result.value = MovieResultState(error = res.message!!)
                }
                is Resource.Loading -> {
                    _result.value = MovieResultState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
