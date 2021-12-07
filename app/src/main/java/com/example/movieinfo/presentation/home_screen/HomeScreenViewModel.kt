package com.example.movieinfo.presentation.home_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieinfo.core.Resource
import com.example.movieinfo.domain.model.MovieSearchByName
import com.example.movieinfo.domain.use_cases.use_case_get_movie_by_name.UseCaseGetMovieByName
import com.example.movieinfo.domain.use_cases.use_case_get_movie_by_title.UseCaseGetMovieByTitle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel
@Inject constructor(
    private val getMovieBySearchUseCase: UseCaseGetMovieByTitle,
    private val getMovieBySearchByNameUseCase: UseCaseGetMovieByName
) : ViewModel() {
    private val _result = mutableStateOf<MovieResultByTitleState>(MovieResultByTitleState())
    val resultByTitle: State<MovieResultByTitleState> = _result

    private val _resultByName = mutableStateOf<MovieResultByNameState>(MovieResultByNameState())
    val resultByName : State<MovieResultByNameState> = _resultByName

    val searchTerm = mutableStateOf<String>("")

    suspend fun getMovieResult(name: String) {
        getMovieBySearchUseCase(name = name).onEach {res->
            when(res){
                is Resource.Success -> {
                    _result.value = res.data?.let { MovieResultByTitleState(movieByTitle = it) }!!
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

    suspend fun getMovieName(name: String) {
        getMovieBySearchByNameUseCase(name = name).onEach {res->
            when(res){
                is Resource.Success -> {
                    _resultByName.value = res.data?.let { MovieResultByNameState(movieByName = it, isLoaded = true) }!!
                }
                is Resource.Error ->{
                    _resultByName.value = MovieResultByNameState(error = res.message!!)
                }
                is Resource.Loading -> {
                    _resultByName.value = MovieResultByNameState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


}
