package com.egsys.crud.integration

import com.egsys.crud.repository.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Testcontainers

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TaskRepositoryTest {
    @Autowired
    private lateinit var taskRepository: TaskRepository
    companion object {
        @org.testcontainers.junit.jupiter.Container
        private val Container = PostgreSQLContainer<Nothing> ("postgres:latest").apply {
            withDatabaseName("testedb")
            withUsername("joao")
            withPassword("12134")
        }
        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", Container::getJdbcUrl)
            registry.add("spring.datasource.password", Container::getPassword)
            registry.add("spring.datasource.username", Container::getUsername)
        }
    }
}