package com.example.fitnessassignment.data.repository

import android.util.Log
import com.example.fitnessassignment.data.mapper.NetworkProgressMapper
import com.example.fitnessassignment.data.remote.FitnessApi
import com.example.fitnessassignment.domain.model.WorkoutProgress
import com.example.fitnessassignment.domain.repository.MainRepository
import com.example.fitnessassignment.utils.EntityMapper
import com.example.fitnessassignment.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "MainRepositoryImpl"
@Singleton
class MainRepositoryImpl @Inject constructor(
    private val api: FitnessApi,
    private val networkMapper: NetworkProgressMapper
): MainRepository {
    override suspend fun getWorkoutProgress(): Flow<Resource<WorkoutProgress>> {
        return flow<Resource<WorkoutProgress>> {
            emit(Resource.Loading(true))
            val workoutProgress = try {
                val response = api.getHomePage()
                emit(Resource.Success(data = networkMapper.mapFromEntity(response)))
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            } catch (e: Exception) {
                Log.d(TAG, "getWorkoutProgress:${e}")
            }

            emit(Resource.Loading(false))
        }

    }

}