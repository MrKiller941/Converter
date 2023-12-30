package com.killer.converter.domain.history

interface IConverterRepository {
    fun getAll(): List<Result>
    fun add(result: Result)

    fun deleteLast(count: Int)
}