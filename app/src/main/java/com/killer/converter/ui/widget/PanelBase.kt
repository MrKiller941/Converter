package com.killer.converter.ui.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.killer.converter.ui.ConverterStateFactory

@Composable
fun PanelBase() {

    val state = ConverterStateFactory.getState()

    val bases = remember { (2..36).toList() }

    var showInputBase by remember { mutableStateOf(false) }
    var showOutputBase by remember { mutableStateOf(false) }

    Row {
        Text(text = "Направление перевода")
        Box() {
            Button(onClick = { showInputBase = true }) {
                Text(text = state.inputBase.toString())
                Icon(Icons.Default.ArrowDropDown, contentDescription = null)
            }
            DropdownMenu(
                expanded = showInputBase,
                onDismissRequest = { showInputBase = false }
            ) {
                bases.map {
                    base -> DropdownMenuItem(text = { Text(text = base.toString()) },
                    onClick = {
                        showInputBase = false
                        state.inputBase = base
                    })
                }
            }
        }
        Button(onClick = {
            val temp = state.inputBase
            state.inputBase = state.outputBase
            state.outputBase = temp
        }) {
            Icon(Icons.Default.KeyboardArrowRight, contentDescription = null)
        }
        Box() {
            Button(onClick = { showOutputBase = true }) {
                Text(text = state.outputBase.toString())
                Icon(Icons.Default.ArrowDropDown, contentDescription = null)
            }
            DropdownMenu(
                expanded = showOutputBase,
                onDismissRequest = { showOutputBase = false }
            ) {
                bases.map {
                        base -> DropdownMenuItem(text = { Text(text = base.toString()) },
                    onClick = {
                        showOutputBase = false
                        state.outputBase = base
                    })
                }
            }
        }
    }
}