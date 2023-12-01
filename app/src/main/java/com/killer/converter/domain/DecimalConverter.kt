package com.killer.converter.domain

import kotlin.math.pow

class DecimalConverter : IDecimalConverter {

    override fun convertToDecimal(number: String, fromBase: Int): Int {
        var decimal = 0
        var power = 0
        for (i in number.length - 1 downTo 0) {
            val digit = NumberUtils.getDigitValue(number[i].toString())!!
            decimal += digit * fromBase.toDouble().pow(power).toInt()
            power++
        }
        return decimal
    }

    override fun convertFromDecimal(decimal: Int, toBase: Int): String {
        var convertedNumber = ""
        var tempDecimal = decimal
        while (tempDecimal > 0) {
            val remainder = tempDecimal % toBase
            val digit = NumberUtils.getDigitSymbol(remainder)!!
            convertedNumber = digit + convertedNumber
            tempDecimal /= toBase
        }
        return convertedNumber dfdfd
    }
}