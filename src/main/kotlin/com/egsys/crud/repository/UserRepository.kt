package com.egsys.crud.repository

import com.egsys.crud.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByPersonEmail(username: String): User? {
        return findByPersonEmail(username)
    }
}