package com.example.yourmovie.data.model

import com.example.yourmovie.model.data.casting.CastData
import com.google.gson.annotations.SerializedName

data class CastingResponse(
    @SerializedName("cast") val cast: List<CastData>,
    @SerializedName("id") val id: Int
)