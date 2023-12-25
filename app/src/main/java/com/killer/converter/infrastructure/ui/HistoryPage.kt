package com.killer.converter.infrastructure.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.killer.converter.infrastructure.ui.widget.ResultWidget
import com.killer.converter.state.ConverterStateSingleton

@Composable
fun HistoryPage() {
    val state = remember { ConverterStateSingleton.getState() }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        state.savedResults.reversed().map {
            ResultWidget(result = it)
        }
    }
}