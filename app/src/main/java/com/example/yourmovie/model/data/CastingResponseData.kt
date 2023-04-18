package com.example.yourmovie.model.data

import com.example.yourmovie.model.data.casting.CastData

data class CastingResponseData(
    val cast: List<CastData>,
    val id: Int
)