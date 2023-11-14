package com.example.fitnessassignment.presentation.home_screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessassignment.domain.repository.MainRepository
import com.example.fitnessassignment.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel@Inject constructor(
    private val repository: MainRepository
): ViewModel() {

    init {
        getWorkoutProgress()
    }
    private fun getWorkoutProgress(){

        viewModelScope.launch {
            repository
                .getWorkoutProgress()
                .collect { result ->
                    when(result) {
                        is Resource.Success -> {
                            result.data?.let { it ->
//                                state = state.copy(
//                                    companies = listings
//                                )
                                Log.d("BISWA", "getWorkoutProgress:${it.message}")
                            }
                        }
                        is Resource.Error -> Unit
                        is Resource.Loading -> {
//                            state = state.copy(isLoading = result.isLoading)
                        }
                    }
                }
        }
    }
}