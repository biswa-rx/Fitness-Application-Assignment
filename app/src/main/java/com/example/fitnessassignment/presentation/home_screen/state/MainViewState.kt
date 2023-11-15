package com.example.fitnessassignment.presentation.home_screen.state

import com.example.fitnessassignment.domain.model.WorkoutProgress

data class MainViewState(
    var workoutProgress: WorkoutProgress? = null,
    var isRequesting: Boolean = false,
    var isResponse: Boolean = false,
    var isRefreshing:Boolean = false,
    var errorMessage: String? = null
)