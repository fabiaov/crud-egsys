package com.egsys.crud.model

import com.egsys.crud.dto.UpdateTaskForm

object UpdateTaskForm {
    fun build() = UpdateTaskForm(
        id = 1L,
        title = "Roronoa zoro",
        description = "yohohohohohoho"
    )

}