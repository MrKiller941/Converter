package com.killer.converter.infrastructure.ui.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.killer.converter.state.ConverterStateSingleton

@Composable
fun PanelResult() {
    val state = remember { ConverterStateSingleton.getState() }

    Row {
        Text(text = "Результат: ")
        if(state.status == "error"){
            Text(text = "ошибка")
        } else if(state.status == "success"){
            Text(text = state.outputNumber!!)
        }
    }

}