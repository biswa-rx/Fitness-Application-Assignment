package com.example.fitnessassignment.data.remote.dto

import com.squareup.moshi.Json

data class Section1(
    @field:Json(name = "plan_name") val plan_name: String,
    @field:Json(name = "progress") val progress: String
)