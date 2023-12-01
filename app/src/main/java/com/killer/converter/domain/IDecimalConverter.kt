package com.killer.converter.domain

interface IDecimalConverter {
    fun convertToDecimal(number: String, fromBase: Int): Int
    fun convertFromDecimal(decimal: Int, toBase: Int): String
}