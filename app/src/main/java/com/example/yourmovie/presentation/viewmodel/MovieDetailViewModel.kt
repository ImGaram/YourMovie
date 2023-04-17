package com.example.yourmovie.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourmovie.model.data.MovieDetailResponseData
import com.example.yourmovie.model.usecase.MovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieDetailUseCase: MovieDetailUseCase
): ViewModel() {
    private val _movieDetail = MutableStateFlow<MovieDetailResponseData?>(null)
    val movieDetail: StateFlow<MovieDetailResponseData?> = _movieDetail

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    fun movieDetail(
        movieId: Int,
        apiKey: String
    ) = viewModelScope.launch {
        movieDetailUseCase(movieId, apiKey).onStart {
            _isLoading.value = true
        }.onCompletion {
            _isLoading.value = false
        }.catch { error ->
            Log.e("TAG", "movieDetail: ${error.printStackTrace()}", error.cause)
        }.collect {
            _movieDetail.value = it
        }
    }
}