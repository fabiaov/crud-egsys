package com.egsys.crud.repository

import com.egsys.crud.model.Task
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository: JpaRepository<Task,Long> {
    fun findByCategoryName(nameCategory: String, pagination: Pageable): Page<Task>
}