package com.egsys.crud.service

import com.egsys.crud.model.Category
import com.egsys.crud.repository.CategoryRepository
import org.springframework.stereotype.Service


@Service
class CategoryService(private val repository: CategoryRepository) {

    fun searchForId(id: Long): Category {
        return repository.getReferenceById(id)
    }
}
