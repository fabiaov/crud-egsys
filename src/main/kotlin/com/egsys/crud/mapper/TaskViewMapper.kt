package com.egsys.crud.mapper

import com.egsys.crud.dto.TaskView
import com.egsys.crud.model.Task
import org.springframework.stereotype.Component

@Component
class TaskViewMapper: Mapper<Task, TaskView> {
    override fun map(t: Task): TaskView {
       return TaskView(
                id = t.id,
                title = t.title,
                description = t.description,
                category = t.category,
                dataCriation = t.dataCriation
        )
    }

}