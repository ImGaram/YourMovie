package com.example.yourmovie.data.api

import com.example.yourmovie.data.model.CastingResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CastingService {
    @GET("3/movie/{movie_id}/credits")
    suspend fun getCasting(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ): CastingResponse
}