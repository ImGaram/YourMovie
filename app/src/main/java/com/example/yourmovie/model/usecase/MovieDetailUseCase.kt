package com.example.yourmovie.model.usecase

import com.example.yourmovie.model.data.MovieDetailResponseData
import com.example.yourmovie.model.repository.MovieDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieDetailUseCase @Inject constructor(
    private val movieDetailRepository: MovieDetailRepository
) {
    suspend operator fun invoke(
        movieId: Int,
        apiKey: String
    ): Flow<MovieDetailResponseData> {
        return movieDetailRepository.movieDetail(movieId, apiKey)
    }
}