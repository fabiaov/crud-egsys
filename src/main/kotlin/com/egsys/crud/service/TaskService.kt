package com.egsys.crud.service

import com.egsys.crud.dto.TaskForm
import com.egsys.crud.dto.TaskView
import com.egsys.crud.dto.UpdateTaskForm
import com.egsys.crud.exception.NotFoundException
import com.egsys.crud.mapper.TaskFormMapper
import com.egsys.crud.mapper.TaskViewMapper
import com.egsys.crud.repository.TaskRepository
import org.springframework.stereotype.Service

import java.util.stream.Collectors



@Service
class TaskService(
        private val repository: TaskRepository,
        private val taskViewMapper: TaskViewMapper,
        private val taskFormMapper: TaskFormMapper,
        private val notFoundMessage: String = "Task no Found!"
) {

    fun list(nameCategory: String?): List<TaskView> {
        val tasks = if (nameCategory == null) {
            repository.findAll()
        } else {
            repository.findByCategoryName(nameCategory)
        }
        return tasks.stream().map { t -> taskViewMapper.map(t) }.collect(Collectors.toList())
    }

    fun searchForId(id: Long): TaskView {
        val task = repository.findById(id).stream().filter {
                t -> t.id == id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        return taskViewMapper.map(task)
    }

    fun register(form : TaskForm): TaskView {
        val task = taskFormMapper.map(form)
        repository.save(task)
        return taskViewMapper.map(task)
    }

    fun update(form: UpdateTaskForm): TaskView {
        val task = repository.findById(form.id).orElseThrow{NotFoundException(notFoundMessage)}
        task.title = form.title
        task.description = form.description
        return taskViewMapper.map(task)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }
}