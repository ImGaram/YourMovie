package com.example.yourmovie.data.api

import com.example.yourmovie.data.model.PopularMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularMovieService {
    @GET("3/movie/popular?language=ko-KR")
    suspend fun getPopularMovie(
        @Query("api_key") apiKey: String
    ): PopularMovieResponse
}