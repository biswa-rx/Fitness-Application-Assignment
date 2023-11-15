package com.example.fitnessassignment.domain

sealed interface RequestResult {
    object RequestSuccessful: RequestResult
    data class Error(val message:String): RequestResult
}