package com.killer.converter.domain

class NumberConverter : INumberConverter {

    val converter: IDecimalConverter = DecimalConverter();

    @Throws(InvalidInputException::class)
    override fun convert(number: String, fromBase: Int, toBase: Int): String {
        if(!NumberUtils.isValidInput(number, fromBase)) throw InvalidInputException();

        if(fromBase == toBase) return number;

        val decimal = converter.convertToDecimal(number, fromBase);
        val convertedNumber = converter.convertFromDecimal(decimal, toBase);
        return convertedNumber;
    }
}