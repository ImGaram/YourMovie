package com.example.yourmovie.model.repository

import com.example.yourmovie.model.data.SearchMovieResponseData
import kotlinx.coroutines.flow.Flow

interface SearchMovieRepository {
    suspend fun searchMovie(
        apiKey: String,
        query: String
    ): Flow<SearchMovieResponseData>
}