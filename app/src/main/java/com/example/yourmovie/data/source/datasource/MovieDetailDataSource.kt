package com.example.yourmovie.data.source.datasource

import com.example.yourmovie.data.model.MovieDetailResponse
import kotlinx.coroutines.flow.Flow

interface MovieDetailDataSource {
    suspend fun movieDetail(
        movieId: Int,
        apiKey: String
    ): Flow<MovieDetailResponse>
}