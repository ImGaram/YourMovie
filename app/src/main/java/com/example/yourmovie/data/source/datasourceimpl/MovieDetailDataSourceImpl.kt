package com.example.yourmovie.data.source.datasourceimpl

import com.example.yourmovie.data.api.MovieDetailService
import com.example.yourmovie.data.model.MovieDetailResponse
import com.example.yourmovie.data.source.datasource.MovieDetailDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieDetailDataSourceImpl @Inject constructor(
    private val service: MovieDetailService
): MovieDetailDataSource {
    override suspend fun movieDetail(
        movieId: Int,
        apiKey: String
    ): Flow<MovieDetailResponse> {
        return flow {
            emit(service.movieDetail(movieId, apiKey))
        }
    }
}