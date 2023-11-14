package com.example.fitnessassignment.data.remote

import com.example.fitnessassignment.data.remote.dto.WorkoutProgressNetworkEntity
import retrofit2.http.GET

interface FitnessApi {

    @GET("homepage_v2/?format=json")
    suspend fun getHomePage(): WorkoutProgressNetworkEntity

    companion object {
        const val BASE_URL = "http://52.25.229.242:8000"
    }
}