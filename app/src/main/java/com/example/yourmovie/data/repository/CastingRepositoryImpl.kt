package com.example.yourmovie.data.repository

import com.example.yourmovie.data.mapper.MovieMapper
import com.example.yourmovie.data.source.datasource.CastingDataSource
import com.example.yourmovie.model.data.CastingResponseData
import com.example.yourmovie.model.repository.CastingRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class CastingRepositoryImpl @Inject constructor(
    private val castingDataSource: CastingDataSource
): CastingRepository {
    override suspend fun getCasting(
        movieId: Int,
        apiKey: String
    ): Flow<CastingResponseData> {
        return flow {
            castingDataSource.getCasting(movieId, apiKey).collect {
                emit(MovieMapper.castingResponseToData(it))
            }
        }
    }
}