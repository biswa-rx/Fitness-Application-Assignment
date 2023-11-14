package com.example.fitnessassignment.utils

interface EntityMapper <Entity, DomainModel>{
    fun mapFromEntity(entity: Entity): DomainModel
    fun mapToEntity(domainModel: DomainModel): Entity
}