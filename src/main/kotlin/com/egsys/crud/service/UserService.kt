package com.egsys.crud.service

import com.egsys.crud.model.User
import com.egsys.crud.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {
    fun searchForId(id: Long): User {
        return repository.getReferenceById(id)
    }
}