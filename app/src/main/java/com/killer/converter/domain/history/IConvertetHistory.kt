package com.killer.converter.domain.history

interface IConvertetHistory {
    fun getHistory(): List<Result>
    fun deleteLast(count: Int)
}