package com.example.fitnessassignment.data.remote.dto

import com.squareup.moshi.Json

data class Data(
    @field:Json(name = "section_1") val section_1: Section1,
    @field:Json(name = "section_2") val section_2: Section2,
    @field:Json(name = "section_3") val section_3: Section3,
    @field:Json(name = "section_4") val section_4: Section4
)