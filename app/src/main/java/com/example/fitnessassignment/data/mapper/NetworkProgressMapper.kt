package com.example.fitnessassignment.data.mapper

import com.example.fitnessassignment.data.remote.dto.WorkoutProgressNetworkEntity
import com.example.fitnessassignment.domain.model.WorkoutProgress
import com.example.fitnessassignment.utils.EntityMapper
import javax.inject.Inject

class NetworkProgressMapper
@Inject
constructor():
    EntityMapper<WorkoutProgressNetworkEntity, WorkoutProgress>{
    override fun mapFromEntity(entity: WorkoutProgressNetworkEntity): WorkoutProgress {
        return WorkoutProgress(
            data = entity.data,
            message = entity.message,
            success = entity.success
        )
    }

    override fun mapToEntity(domainModel: WorkoutProgress): WorkoutProgressNetworkEntity {
        return WorkoutProgressNetworkEntity(
            data = domainModel.data,
            message = domainModel.message,
            success = domainModel.success
        )
    }
}

