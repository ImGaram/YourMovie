package com.example.yourmovie.data.source.datasourceimpl

import com.example.yourmovie.data.api.CastingService
import com.example.yourmovie.data.model.CastingResponse
import com.example.yourmovie.data.source.datasource.CastingDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CastingDataSourceImpl @Inject constructor(
    private val castingService: CastingService
): CastingDataSource {
    override suspend fun getCasting(
        movieId: Int,
        apiKey: String
    ): Flow<CastingResponse> {
        return flow {
            emit(castingService.getCasting(movieId, apiKey))
        }
    }
}