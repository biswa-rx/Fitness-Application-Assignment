package com.example.fitnessassignment.presentation.home_screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessassignment.domain.RequestResult
import com.example.fitnessassignment.domain.repository.MainRepository
import com.example.fitnessassignment.presentation.home_screen.state.MainViewState
import com.example.fitnessassignment.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel@Inject constructor(
    private val repository: MainRepository
): ViewModel() {

    private var _state = MutableStateFlow(MainViewState())
    val mainViewState : StateFlow<MainViewState>
        get() = _state.asStateFlow()

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
                                _state.value.workoutProgress = it
                                Log.d("BISWA", "getWorkoutProgress:${it.message}")
                            }
                        }
                        is Resource.Error -> Unit
                        is Resource.Loading -> {
                            _state.value.isRefreshing = result.isLoading
                        }
                    }
                }
        }
    }

    fun onRefreshScreen(){

    }

//    private fun Flow<RequestResult>.listen(): Job {
//        return onEach { result ->
//            when(result) {
//                RequestResult.RequestSuccessful -> {
//                    _state.update { it.copy(
//                        isResponse = true,
//                        isRequesting = false,
//                        errorMessage = null,
//                        isRefreshing = false,
//                    ) }
//                }
//                is RequestResult.Error -> {
//                    _state.update { it.copy(
//                        isRequesting = false,
//                        isResponse = true,
//                        isRefreshing = false,
//                        errorMessage = result.message
//                    ) }
//                }
//            }
//        }.catch { throwable ->
//            _state.update { it.copy(
//                isRequesting = false,
//                isResponse = false,
//                isRefreshing = false
//            ) }
//        }
//            .launchIn(viewModelScope)
//    }
}