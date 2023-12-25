package com.killer.converter.infrastructure.ui.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.killer.converter.state.ConverterStateSingleton

@Composable
fun PanelControl(navController: NavHostController) {

    val state = remember { ConverterStateSingleton.getState() }
    
    Row {
        Button(onClick = { state.convert() }) {
            Text(text = "Вычислить")
        }
        Button(onClick = {
            state.updateHistory()
            navController.navigate("history")
        }) {
            Text(text = "История")
        }
    }
}