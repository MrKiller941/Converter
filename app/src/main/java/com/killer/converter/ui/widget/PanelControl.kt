package com.killer.converter.ui.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.killer.converter.ui.ConverterStateFactory

@Composable
fun PanelControl() {

    val state = ConverterStateFactory.getState()
    
    Row {
        Button(onClick = { state.convert() }) {
            Text(text = "Вычислить")
        }
    }
}