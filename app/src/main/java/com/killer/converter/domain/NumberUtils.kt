package com.killer.converter.domain

object NumberUtils {

    fun getDigitValue(digit: String): Int? {
        return try {
            digit.toInt();
        } catch (e: NumberFormatException){
            if (Regex("[a-zA-Z]+").matches(digit)){
                digit.uppercase()[0].code - 'A'.code + 10
            } else {
                null
            }
        }
    }

    fun getDigitSymbol(value: Int): String? {
        return when (value) {
            in 0..9 -> value.toString()
            in 10 until 36 -> ('A'.code + (value - 10)).toChar().toString()
            else -> null
        }
    }

    fun isValidInput(number: String, base: Int): Boolean {
        if (number.isEmpty()) return false
        for (i in number.indices) {
            val digit = number[i].toString()
            if (!isDigitValid(digit, base)) {
                return false
            }
        }
        return true
    }

    private fun isDigitValid(digit: String, base: Int): Boolean {
        val maxValue = base - 1
        if (Regex("[0-9]").matches(digit)) {
            val value = digit.toInt()
            return value <= maxValue
        }
        val maxAlphaValue = base - 11
        if (Regex("[a-zA-Z]").matches(digit)) {
            val value = digit.uppercase()[0].code - 'A'.code
            return value <= maxAlphaValue
        }
        return false
    }
}