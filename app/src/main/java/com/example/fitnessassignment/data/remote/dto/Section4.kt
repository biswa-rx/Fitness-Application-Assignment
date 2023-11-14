package com.example.fitnessassignment.data.remote.dto

import com.squareup.moshi.Json

data class Section4(
    @field:Json(name = "category_1") val category_1: Category1,
    @field:Json(name = "category_2") val category_2: Category1
)