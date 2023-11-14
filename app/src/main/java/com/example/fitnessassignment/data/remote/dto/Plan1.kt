package com.example.fitnessassignment.data.remote.dto

import com.squareup.moshi.Json

data class Plan1(
    @field:Json(name = "difficulty") val difficulty: String,
    @field:Json(name = "plan_name") val plan_name: String
)