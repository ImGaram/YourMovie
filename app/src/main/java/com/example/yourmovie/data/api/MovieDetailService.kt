package com.example.yourmovie.data.api

import com.example.yourmovie.data.model.MovieDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailService {
    @GET("3/movie/{movie_id}?language=ko-KR")
    suspend fun movieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ): MovieDetailResponse
}