package com.joaogdantas.SimpleBusinessCardApp.service

import org.springframework.stereotype.Service

@Service
interface CrudService<T, UUID> {
    fun findAll(): List<T>
    fun findById(id: UUID): T
    fun create(model: T): T
    fun update(id: UUID, model: T): T
    fun delete(id: UUID)
}