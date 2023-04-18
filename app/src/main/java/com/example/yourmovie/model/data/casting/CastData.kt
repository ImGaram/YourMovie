package com.example.yourmovie.model.data.casting

data class CastData(
    val character: String,
    val gender: Int,
    val knownForDepartment: String,
    val name: String,
    val order: Int,
    val originalName: String,
    val profilePath: String?
)