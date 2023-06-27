package com.egsys.crud.model


import jakarta.persistence.*
import java.time.LocalDateTime
import jakarta.persistence.ManyToOne
import org.hibernate.annotations.CreationTimestamp




@Entity
data class Task (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var title: String,
        var description: String,
        @ManyToOne
        @JoinColumn(name = "category_id")
        var category: Category,
        @ManyToOne
        @JoinColumn(name = "user_id")
        var autor: User,
        @CreationTimestamp
        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "data_creation")
        val dataCreation: LocalDateTime = LocalDateTime.now()
)