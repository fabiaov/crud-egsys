package com.egsys.crud.repository

import com.egsys.crud.model.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository: JpaRepository<Category, Long > {
}