package com.example.yourmovie.model.repository

import com.example.yourmovie.model.data.MovieDetailResponseData
import kotlinx.coroutines.flow.Flow

interface MovieDetailRepository {
    suspend fun movieDetail(
        movieId: Int,
        apiKey: String
    ): Flow<MovieDetailResponseData>
}