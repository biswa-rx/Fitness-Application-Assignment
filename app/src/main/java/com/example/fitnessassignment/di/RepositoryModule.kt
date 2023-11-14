package com.example.fitnessassignment.di

import com.example.fitnessassignment.data.mapper.NetworkProgressMapper
import com.example.fitnessassignment.data.remote.FitnessApi
import com.example.fitnessassignment.data.repository.MainRepositoryImpl
import com.example.fitnessassignment.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMainRepository(
        api: FitnessApi,
        networkMapper: NetworkProgressMapper
    ): MainRepository {
        return MainRepositoryImpl(api, networkMapper)
    }
}