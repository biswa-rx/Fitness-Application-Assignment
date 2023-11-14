package com.example.fitnessassignment.data.remote.dto

import com.squareup.moshi.Json

data class Section3(
    @field:Json(name = "plan_1") val plan_1: Plan1,
    @field:Json(name = "plan_2") val plan_2: Plan1
)