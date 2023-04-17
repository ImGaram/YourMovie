package com.example.yourmovie.data.source.datasource

import com.example.yourmovie.data.model.search.SearchMovieResponse
import kotlinx.coroutines.flow.Flow

interface SearchMovieDataSource {
    suspend fun searchMovie(
        apiKey: String,
        query: String
    ): Flow<SearchMovieResponse>
}