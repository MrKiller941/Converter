package com.killer.converter.domain

interface INumberConverter {
    fun convert(number: String, fromBase: Int, toBase: Int): String?
}