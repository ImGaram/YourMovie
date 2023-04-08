package com.example.yourmovie.data.model

import com.google.gson.annotations.SerializedName

data class SearchMovieResponse(
    @SerializedName("lastBuildDate") val lastBuildDate: String,
    @SerializedName("total") val total: Int,
    @SerializedName("start") val start: Int,
    @SerializedName("display") val display: Int,
    @SerializedName("items") val movieItems: List<MovieItem>
)