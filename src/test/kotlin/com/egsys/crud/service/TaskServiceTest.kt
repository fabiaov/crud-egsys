package com.egsys.crud.service
import com.egsys.crud.exception.NotFoundException
import com.egsys.crud.mapper.TaskFormMapper
import com.egsys.crud.mapper.TaskViewMapper
import com.egsys.crud.model.TaskTest
import com.egsys.crud.model.TaskViewTest
import io.mockk.mockk
import com.egsys.crud.repository.TaskRepository
import io.mockk.every
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import java.util.*

class TaskServiceTest {
    val tasks = PageImpl(listOf(TaskTest.build()))
    val pagination: Pageable = mockk()
    val taskRepository: TaskRepository = mockk{
        every {
            findByCategoryName(any(), any())
        } returns tasks
        every { findAll(pagination) } returns tasks
    }
    val taskViewMapper: TaskViewMapper = mockk{
        every { map(any()) } returns TaskViewTest.build()
    }
    val taskFormMapper: TaskFormMapper = mockk()

    val taskService = TaskService(
        taskRepository, taskViewMapper, taskFormMapper
    )

    @Test
    fun `must list tasks from category name`(){

        taskService.list("Casa", pagination)
        verify(exactly = 1) { taskRepository.findByCategoryName(any(),any()) }
        verify(exactly = 1) { taskViewMapper.map(any()) }
        verify(exactly = 0) { taskRepository.findAll(pagination) }
    }

    @Test
    fun `must list all tasks when Category name is null`() {
        taskService.list(null, pagination)
        verify(exactly = 0) { taskRepository.findByCategoryName(any(),any()) }
        verify(exactly = 1) { taskViewMapper.map(any()) }
        verify(exactly = 1) { taskRepository.findAll(pagination) }
    }

    @Test
    fun `must list not found exception when task not found`() {
        every { taskRepository.findById(any()) } returns Optional.empty()

        val actual = assertThrows<NotFoundException> {
            taskService.searchForId(1)
        }
        assertThat(actual.message).isEqualTo("Task no Found!")
    }

}