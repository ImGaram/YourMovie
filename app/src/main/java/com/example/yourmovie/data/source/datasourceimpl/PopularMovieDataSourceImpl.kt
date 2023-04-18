package com.example.yourmovie.data.source.datasourceimpl

import com.example.yourmovie.data.api.PopularMovieService
import com.example.yourmovie.data.model.PopularMovieResponse
import com.example.yourmovie.data.source.datasource.PopularMovieDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PopularMovieDataSourceImpl @Inject constructor(
    private val popularMovieService: PopularMovieService
): PopularMovieDataSource {
    override suspend fun getPopularMovie(
        apiKey: String
    ): Flow<PopularMovieResponse> {
        return flow {
            emit(popularMovieService.getPopularMovie(apiKey))
        }
    }
}