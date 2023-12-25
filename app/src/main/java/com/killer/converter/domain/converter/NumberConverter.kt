package com.killer.converter.domain.converter

import com.killer.converter.domain.history.IConverterRepository
import com.killer.converter.domain.history.IConvertetHistory
import com.killer.converter.domain.history.Result
import com.killer.converter.infrastructure.shared.DatabaseResults

class NumberConverter : INumberConverter {

    private val converter: IDecimalConverter = DecimalConverter()
    private val repository: IConverterRepository = DatabaseResults

    @Throws(InvalidInputException::class)
    override fun convert(number: String, fromBase: Int, toBase: Int): String {
        if(!NumberUtils.isValidInput(number, fromBase)) throw InvalidInputException()

        if(fromBase == toBase) {
            repository.add(Result(
                inputBase = fromBase,
                outputBase = toBase,
                inputNumber = number,
                outputNumber = number
            ))
            return number
        };

        val decimal = converter.convertToDecimal(number, fromBase)
        val convertedNumber = converter.convertFromDecimal(decimal, toBase)
        repository.add(Result(
            inputBase = fromBase,
            outputBase = toBase,
            inputNumber = number,
            outputNumber = convertedNumber
        ))
        return convertedNumber
    }
}