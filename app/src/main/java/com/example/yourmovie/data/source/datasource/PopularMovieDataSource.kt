package com.example.yourmovie.data.source.datasource

import com.example.yourmovie.data.model.PopularMovieResponse
import kotlinx.coroutines.flow.Flow

interface PopularMovieDataSource {
    suspend fun getPopularMovie(
        apiKey: String
    ): Flow<PopularMovieResponse>
}