package com.egsys.crud.model

import com.egsys.crud.dto.TaskForm

object TaskFormTest {
    fun build() = TaskForm(
        title = "monkey d luffy",
        description =  "jfasdosdafoksajdiofja",
        idCategory = 1L,
    )
}