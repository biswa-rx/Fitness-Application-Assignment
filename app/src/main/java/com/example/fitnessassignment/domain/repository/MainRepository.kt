package com.example.fitnessassignment.domain.repository

import com.example.fitnessassignment.domain.model.WorkoutProgress
import com.example.fitnessassignment.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun getWorkoutProgress(): Flow<Resource<WorkoutProgress>>
}