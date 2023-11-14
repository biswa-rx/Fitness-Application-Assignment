package com.example.fitnessassignment.data.remote.dto

import com.squareup.moshi.Json

data class WorkoutProgressNetworkEntity(
    @field:Json(name = "data") val `data`: Data,
    @field:Json(name = "message") val message: String,
    @field:Json(name = "success") val success: Boolean
)