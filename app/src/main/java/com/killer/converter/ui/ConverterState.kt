package com.killer.converter.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.killer.converter.domain.InvalidInputException
import com.killer.converter.domain.NumberConverter

val converter = NumberConverter()

class ConverterState {
    var inputNumber by mutableStateOf("")
    var inputBase by mutableStateOf(10)
    var outputBase by mutableStateOf(2)
    var outputNumber by mutableStateOf<String?>(null)
    var status by mutableStateOf("init")

    fun convert(){
        try {
            outputNumber = converter.convert(inputNumber, inputBase, outputBase)
            status = "success"
        } catch (e: InvalidInputException){
            status = "error"
        }
    }
}

object ConverterStateFactory {
    private var instance: ConverterState? = null

    fun getState(): ConverterState {
        if (instance == null){
            instance = ConverterState()
        }
        return instance!!
    }
}