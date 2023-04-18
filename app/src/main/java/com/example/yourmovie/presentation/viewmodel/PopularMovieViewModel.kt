package com.example.yourmovie.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourmovie.model.data.PopularMovieResponseData
import com.example.yourmovie.model.usecase.PopularMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularMovieViewModel @Inject constructor(
    private val popularMovieUseCase: PopularMovieUseCase
): ViewModel() {
    private val _popularMovie = MutableStateFlow<PopularMovieResponseData?>(null)
    val popularMovie: StateFlow<PopularMovieResponseData?> = _popularMovie
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading
    
    fun getPopularMovie(apiKey: String) = viewModelScope.launch { 
        popularMovieUseCase(apiKey).onStart { 
            _isLoading.value = true
        }.onCompletion {
            _isLoading.value = false
        }.catch { err ->
            Log.e("TAG", "getPopularMovie: ${err.printStackTrace()}", err.cause)
        }.collect {
            _popularMovie.value = it
        }
    }
}