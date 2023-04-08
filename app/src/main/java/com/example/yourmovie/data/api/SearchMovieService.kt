package com.example.yourmovie.data.api

import com.example.yourmovie.data.model.SearchMovieResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SearchMovieService {
    @GET("/v1/search/movie.json")
    suspend fun searchMovie(
        @Header("X-Naver-Client-Id") clientId: String,
        @Header("X-Naver-Client-Secret") clientSecret: String,
        @Query("query") query: String
    ): SearchMovieResponse
}