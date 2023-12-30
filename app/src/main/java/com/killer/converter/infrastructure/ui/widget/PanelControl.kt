package com.killer.converter.infrastructure.ui.widget

import android.widget.NumberPicker
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.killer.converter.state.ConverterStateSingleton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PanelControl(navController: NavHostController) {

    val state = remember { ConverterStateSingleton.getState() }
    var count by remember { mutableStateOf("") }
    
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
        Button(onClick = {
            if(count.isEmpty()){
                state.deleteHistory(-1)
            } else {
                state.deleteHistory(count.toInt())
            }
        }) {
            Text(text = "Удалить")
        }
        TextField(value = count, onValueChange = {
            count = it
        })
    }
}