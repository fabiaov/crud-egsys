package com.egsys.crud.mapper

import com.egsys.crud.dto.TaskForm
import com.egsys.crud.model.Task
import com.egsys.crud.service.CategoryService
import org.springframework.stereotype.Component

@Component
class TaskFormMapper(
        private val categoryService: CategoryService
): Mapper<TaskForm, Task> {
    override fun map(t: TaskForm): Task {
        return Task(
                title = t.title,
                description = t.description,
                category = categoryService.searchForId(t.idCategory)
        )
    }

}
