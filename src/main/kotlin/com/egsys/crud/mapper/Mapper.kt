package com.egsys.crud.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}
