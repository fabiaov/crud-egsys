package com.egsys.crud.controller

import com.egsys.crud.dto.TaskForm
import com.egsys.crud.dto.TaskView
import com.egsys.crud.dto.UpdateTaskForm
import com.egsys.crud.service.TaskService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import java.util.*

@RestController
@RequestMapping("/tasks")
class TaskController(private val service: TaskService) {


    @GetMapping
    fun list(): List<TaskView> {
       return service.list()
    }

    @GetMapping("/{id}")
    fun searchForId(@PathVariable id: Long): TaskView {
        return service.searchForId(id)
    }

    @PostMapping
    @Transactional
    fun register(
        @RequestBody @Valid form: TaskForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TaskView>{
        val taskView = service.register(form)
        val uri = uriBuilder.path( "/tasks/${taskView.id}").build().toUri()
        return ResponseEntity.created(uri).body(taskView)
    }

    @PutMapping
    @Transactional
    fun update(@RequestBody @Valid form: UpdateTaskForm):ResponseEntity<TaskView> {
        val taskView = service.update(form)
        return ResponseEntity.ok(taskView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun delete(@PathVariable id: Long){
        service.delete(id)
    }
}