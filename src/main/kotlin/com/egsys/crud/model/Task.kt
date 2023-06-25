package com.egsys.crud.model


import jakarta.persistence.*
import java.time.LocalDateTime
import jakarta.persistence.ManyToOne


@Entity
data class Task (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var title: String,
        var description: String,
        @ManyToOne
        @JoinColumn(name = "category_id")
        var category: Category,
        val dataCriation: LocalDateTime = LocalDateTime.now()
)