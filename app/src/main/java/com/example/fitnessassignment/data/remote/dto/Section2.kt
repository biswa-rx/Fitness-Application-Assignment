package com.example.fitnessassignment.data.remote.dto

import com.squareup.moshi.Json

data class Section2(
    @field:Json(name = "accuracy") val accuracy: String,
    @field:Json(name = "calories_burned") val calories_burned: Int,
    @field:Json(name = "reps") val reps: Int,
    @field:Json(name = "workout_duration") val workout_duration: String
)