package com.killer.converter.ui.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.killer.converter.ui.ConverterStateFactory

@Composable
fun PanelResult() {
    val state = ConverterStateFactory.getState()

    Row {
        Text(text = "Результат: ")
        if(state.status == "error"){
            Text(text = "ошибка")
        } else if(state.status == "success"){
            Text(text = state.outputNumber!!)
        }
    }

}