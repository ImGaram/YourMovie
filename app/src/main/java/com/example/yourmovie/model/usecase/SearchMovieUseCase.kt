package com.example.yourmovie.model.usecase

import com.example.yourmovie.model.data.SearchMovieResponseData
import com.example.yourmovie.model.repository.SearchMovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchMovieUseCase @Inject constructor(
    private val searchMovieRepository: SearchMovieRepository
) {
    suspend operator fun invoke(
        apiKey: String,
        query: String
    ): Flow<SearchMovieResponseData> {
        return searchMovieRepository.searchMovie(apiKey, query)
    }
}