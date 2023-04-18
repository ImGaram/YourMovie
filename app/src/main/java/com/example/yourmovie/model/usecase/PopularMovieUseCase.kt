package com.example.yourmovie.model.usecase

import com.example.yourmovie.model.data.PopularMovieResponseData
import com.example.yourmovie.model.repository.PopularMovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PopularMovieUseCase @Inject constructor(
    private val popularMovieRepository: PopularMovieRepository
) {
    suspend operator fun invoke(
        apiKey: String
    ): Flow<PopularMovieResponseData> {
        return popularMovieRepository.getPopularMovie(apiKey)
    }
}