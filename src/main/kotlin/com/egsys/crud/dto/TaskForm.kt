package com.egsys.crud.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size


data class TaskForm(
    @field:NotEmpty(message = "Title must not be blank")
    @field:Size(min = 5, max = 200, message = "Title must have between 5 and 200 characters")
    val title: String,
    @field:NotEmpty(message = "description must not be blank")
    val description: String,
    @field:NotNull
    val idCategory: Long,

    )
