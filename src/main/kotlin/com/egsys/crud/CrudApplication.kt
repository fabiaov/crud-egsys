package com.egsys.crud
import org.springframework.core.env.Environment
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CrudApplication

fun main(args: Array<String>) {
    runApplication<CrudApplication>(*args)
}
