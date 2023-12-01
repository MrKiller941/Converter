package com.killer.converter.ui.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType
import com.killer.converter.ui.ConverterStateFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PanelInput() {

    val state = ConverterStateFactory.getState()

    Row() {
        Text(
            text = "Исходное число",
        )
        TextField(value = state.inputNumber, onValueChange = {
            text -> state.inputNumber = text
        },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii),
            singleLine = true
        )
    }
}