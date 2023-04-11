package com.example.yourmovie.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourmovie.model.data.SearchMovieResponseData
import com.example.yourmovie.model.usecase.SearchMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchMovieViewModel @Inject constructor(
    private val searchMovieUseCase: SearchMovieUseCase
): ViewModel() {
    private val _searchMovie = MutableStateFlow<SearchMovieResponseData?>(null)
    val searchMovie: StateFlow<SearchMovieResponseData?> = _searchMovie

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    fun searchMovie(
        apiKey: String,
        query: String
    ) = viewModelScope.launch {
        searchMovieUseCase(apiKey, query).onStart {
            _isLoading.value = true
        }.onCompletion {
            _isLoading.value = false
        }.catch { error ->
            Log.e("TAG", "searchMovie: ${error.printStackTrace()}", error.cause)
        }.collect {
            _searchMovie.value = it
            Log.d("TAG", "searchMovie search movie: ${_searchMovie.value}")
        }
    }
}