package com.killer.converter.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.killer.converter.domain.converter.InvalidInputException
import com.killer.converter.domain.converter.NumberConverter
import com.killer.converter.domain.history.ConverterHistory
import com.killer.converter.domain.history.Result

val converter = NumberConverter()
val history = ConverterHistory()

class ConverterState {
    var inputNumber by mutableStateOf("")
    var inputBase by mutableStateOf(10)
    var outputBase by mutableStateOf(2)
    var outputNumber by mutableStateOf<String?>(null)
    var status by mutableStateOf("init")
    var savedResults by mutableStateOf<List<Result>>(emptyList())

    fun convert(){
        try {
            outputNumber = converter.convert(inputNumber, inputBase, outputBase)
            status = "success"
        } catch (e: InvalidInputException){
            status = "error"
        }
    }

    fun updateHistory(){
        savedResults = history.getHistory()
    }

    fun deleteHistory(count: Int){
        history.deleteLast(count)
    }
}

object ConverterStateSingleton {
    private var instance: ConverterState? = null

    fun getState(): ConverterState {
        if (instance == null){
            instance = ConverterState()
        }
        return instance!!
    }
}