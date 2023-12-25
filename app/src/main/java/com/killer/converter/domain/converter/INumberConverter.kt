package com.killer.converter.domain.converter

interface INumberConverter {
    fun convert(number: String, fromBase: Int, toBase: Int): String?
}