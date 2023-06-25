package com.egsys.crud.dto

import com.egsys.crud.model.Category
import java.time.LocalDateTime


data class TaskView(
        val id: Long?,
        val title: String,
        val description: String,
        val category: Category,
        val dataCriation: LocalDateTime

) {

}
