package com.example.yourmovie.data.source.datasource

import com.example.yourmovie.data.model.CastingResponse
import kotlinx.coroutines.flow.Flow

interface CastingDataSource {
    suspend fun getCasting(
        movieId: Int,
        apiKey: String
    ): Flow<CastingResponse>
}