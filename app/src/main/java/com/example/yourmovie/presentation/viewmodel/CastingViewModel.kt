package com.example.yourmovie.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourmovie.model.data.CastingResponseData
import com.example.yourmovie.model.usecase.CastingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CastingViewModel @Inject constructor(
    private val castingUseCase: CastingUseCase
): ViewModel() {
    private val _casting = MutableStateFlow<CastingResponseData?>(null)
    val casting: StateFlow<CastingResponseData?> = _casting

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun getCasting(movieId: Int, apiKey: String) = viewModelScope.launch {
        castingUseCase(movieId, apiKey).onStart {
            _isLoading.value = true
        }.onCompletion {
            _isLoading.value = false
        }.catch { err ->
            Log.e("TAG", "getCasting: ${err.printStackTrace()}", err.cause)
        }.collect {
            _casting.value = it
        }
    }
}