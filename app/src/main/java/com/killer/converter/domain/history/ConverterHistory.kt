package com.killer.converter.domain.history

import com.killer.converter.infrastructure.shared.DatabaseResults

class ConverterHistory : IConvertetHistory {

    private val repository = DatabaseResults

    override fun getHistory(): List<Result> {
        return repository.getAll()
    }
}