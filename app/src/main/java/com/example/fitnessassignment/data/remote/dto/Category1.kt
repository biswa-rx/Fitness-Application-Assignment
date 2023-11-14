package com.example.fitnessassignment.data.remote.dto

import com.squareup.moshi.Json

data class Category1(
    @field:Json(name = "category_name") val category_name: String,
    @field:Json(name = "no_of_exercises") val no_of_exercises: String
)