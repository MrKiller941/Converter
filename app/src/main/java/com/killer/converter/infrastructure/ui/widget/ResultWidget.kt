package com.killer.converter.infrastructure.ui.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.killer.converter.domain.history.Result

@Composable
fun ResultWidget(result: Result) {
    Row() {
        Text(text = result.inputNumber, fontSize = 32.sp)
        Text(text = "(${result.inputBase})", fontSize = 16.sp)

        Text(text = " = ", fontSize = 32.sp)

        Text(text = result.outputNumber, fontSize = 32.sp)
        Text(text = "(${result.outputBase})", fontSize = 16.sp)
    }
}