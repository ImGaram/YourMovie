package com.example.yourmovie.model.repository

import com.example.yourmovie.model.data.PopularMovieResponseData
import kotlinx.coroutines.flow.Flow

interface PopularMovieRepository {
    suspend fun getPopularMovie(
        apiKey: String
    ): Flow<PopularMovieResponseData>
}