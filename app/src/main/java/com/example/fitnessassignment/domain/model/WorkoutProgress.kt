package com.example.fitnessassignment.domain.model

import com.example.fitnessassignment.data.remote.dto.Data

data class WorkoutProgress(
    val `data`: Data,
    val message: String,
    val success: Boolean
)