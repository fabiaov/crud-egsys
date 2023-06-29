package com.egsys.crud.model

object TaskTest {
    fun build() = Task(
        id = 1,
        title = "Fazer comida",
        description = "não Esquecer comida no fogo e fazer outra coisa",
        category = CategoryTest.build()
    )
}