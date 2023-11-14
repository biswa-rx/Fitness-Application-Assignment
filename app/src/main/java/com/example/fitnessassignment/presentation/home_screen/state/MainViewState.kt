package com.example.fitnessassignment.presentation.home_screen.state

import com.example.fitnessassignment.domain.model.WorkoutProgress

data class MainViewState(
    var workoutProgress: WorkoutProgress? = null,
    val isRefreshing: Boolean = false,
    var isLoading: Boolean = false,
    var error: String? = null
)