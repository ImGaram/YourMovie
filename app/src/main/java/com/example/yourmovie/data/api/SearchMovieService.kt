package com.example.yourmovie.data.api

import com.example.yourmovie.data.model.SearchMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchMovieService {
    @GET("3/search/movie?language=ko-KR&page=1")
    suspend fun searchMovie(
        @Query("api_key") apiKey: String,
        @Query("query") query: String
    ): SearchMovieResponse
}