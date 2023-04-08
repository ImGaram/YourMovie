package com.example.yourmovie.model.repository

import com.example.yourmovie.model.data.SearchMovieResponseData
import kotlinx.coroutines.flow.Flow

interface SearchMovieRepository {
    suspend fun searchMovie(
        clientId: String,
        clientSecret: String,
        query: String
    ): Flow<SearchMovieResponseData>
}