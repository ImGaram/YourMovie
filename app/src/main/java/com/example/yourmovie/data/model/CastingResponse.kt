package com.example.yourmovie.data.model

import com.example.yourmovie.data.model.casting.Cast
import com.google.gson.annotations.SerializedName

data class CastingResponse(
    @SerializedName("cast") val cast: List<Cast>,
    @SerializedName("id") val id: Int
)