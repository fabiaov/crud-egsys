package com.egsys.crud.model

import jakarta.persistence.*




@Entity
@Table(name = "category")
data class Category(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        val name: String
)
