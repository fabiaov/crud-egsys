package com.egsys.crud.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class UpdateTaskForm(
    @field:NotNull
    val id: Long,
    @field:NotEmpty
    @field:Size(min = 5, max = 200)
    val title: String,
    @field:NotEmpty
    val description: String

)


