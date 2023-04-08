package com.example.yourmovie.data.source.datasource

import com.example.yourmovie.data.model.SearchMovieResponse
import kotlinx.coroutines.flow.Flow

interface SearchMovieDataSource {
    suspend fun searchMovie(
        clientId: String,
        clientSecret: String,
        query: String
    ): Flow<SearchMovieResponse>
}