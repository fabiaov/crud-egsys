package com.egsys.crud.model

import com.egsys.crud.dto.TaskView
import java.time.LocalDate
import java.time.LocalDateTime

object TaskViewTest {
    fun build() = TaskView(
        id = 1,
        title = "Fazer comida",
        description = "nao Esquecer comida no fogo e fazer outra coisa",
        category = CategoryTest.build(),
        dataCriation = LocalDateTime.now(),
        changeData = LocalDate.now()
    )
}