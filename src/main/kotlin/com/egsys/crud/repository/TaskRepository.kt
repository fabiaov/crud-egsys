package com.egsys.crud.repository

import com.egsys.crud.model.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository: JpaRepository<Task,Long> {
}