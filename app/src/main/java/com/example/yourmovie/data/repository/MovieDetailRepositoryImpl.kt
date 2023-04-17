package com.example.yourmovie.data.repository

import com.example.yourmovie.data.mapper.MovieMapper
import com.example.yourmovie.data.source.datasource.MovieDetailDataSource
import com.example.yourmovie.model.data.MovieDetailResponseData
import com.example.yourmovie.model.repository.MovieDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieDetailRepositoryImpl @Inject constructor(
    private val movieDetailDataSource: MovieDetailDataSource
): MovieDetailRepository {
    override suspend fun movieDetail(
        movieId: Int,
        apiKey: String
    ): Flow<MovieDetailResponseData> {
        return flow {
            movieDetailDataSource.movieDetail(movieId, apiKey).collect {
                emit(MovieMapper.movieDetailResponseToData(it))
            }
        }
    }
}