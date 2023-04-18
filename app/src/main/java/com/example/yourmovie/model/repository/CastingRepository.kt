package com.example.yourmovie.model.repository

import com.example.yourmovie.model.data.CastingResponseData
import kotlinx.coroutines.flow.Flow

interface CastingRepository {
    suspend fun getCasting(
        movieId: Int,
        apiKey: String
    ): Flow<CastingResponseData>
}