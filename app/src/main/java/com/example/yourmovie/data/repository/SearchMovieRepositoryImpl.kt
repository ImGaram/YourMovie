package com.example.yourmovie.data.repository

import com.example.yourmovie.data.mapper.MovieMapper
import com.example.yourmovie.data.source.datasource.SearchMovieDataSource
import com.example.yourmovie.model.data.SearchMovieResponseData
import com.example.yourmovie.model.repository.SearchMovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchMovieRepositoryImpl @Inject constructor(
    private val searchMovieDataSource: SearchMovieDataSource
): SearchMovieRepository {
    override suspend fun searchMovie(
        clientId: String,
        clientSecret: String,
        query: String
    ): Flow<SearchMovieResponseData> {
        return flow {
            searchMovieDataSource.searchMovie(clientId, clientSecret, query).collect {
                emit(MovieMapper.searchMovieToData(it))
            }
        }
    }
}