package com.example.yourmovie.data.model.casting

import com.google.gson.annotations.SerializedName

data class Cast(
    @SerializedName("character") val character: String,
    @SerializedName("gender") val gender: Int,
    @SerializedName("known_for_department") val knownForDepartment: String,
    @SerializedName("name") val name: String,
    @SerializedName("order") val order: Int,
    @SerializedName("original_name") val originalName: String,
    @SerializedName("profile_path") val profilePath: String
)