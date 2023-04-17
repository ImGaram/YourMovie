package com.example.yourmovie.data.source.datasourceimpl

import com.example.yourmovie.data.api.SearchMovieService
import com.example.yourmovie.data.model.search.SearchMovieResponse
import com.example.yourmovie.data.source.datasource.SearchMovieDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchMovieDataSourceImpl @Inject constructor(
    private val searchMovieService: SearchMovieService
): SearchMovieDataSource {
    override suspend fun searchMovie(
        apiKey: String,
        query: String
    ): Flow<SearchMovieResponse> {
        return flow {
            emit(searchMovieService.searchMovie(apiKey, query))
        }
    }
}