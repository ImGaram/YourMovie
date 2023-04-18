package com.example.yourmovie.data.repository

import com.example.yourmovie.data.mapper.MovieMapper
import com.example.yourmovie.data.source.datasource.PopularMovieDataSource
import com.example.yourmovie.model.data.PopularMovieResponseData
import com.example.yourmovie.model.repository.PopularMovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PopularMovieRepositoryImpl @Inject constructor(
    private val popularMovieDataSource: PopularMovieDataSource
): PopularMovieRepository {
    override suspend fun getPopularMovie(
        apiKey: String
    ): Flow<PopularMovieResponseData> {
        return flow {
            popularMovieDataSource.getPopularMovie(apiKey).collect {
                emit(MovieMapper.popularMovieResponseToData(it))
            }
        }
    }
}