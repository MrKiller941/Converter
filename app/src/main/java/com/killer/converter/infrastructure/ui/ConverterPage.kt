package com.killer.converter.infrastructure.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.killer.converter.infrastructure.ui.widget.PanelBase
import com.killer.converter.infrastructure.ui.widget.PanelControl
import com.killer.converter.infrastructure.ui.widget.PanelInput
import com.killer.converter.infrastructure.ui.widget.PanelResult

@Composable
fun ConverterPage(navController: NavHostController) {
    Column {
        PanelInput()
        PanelBase()
        PanelControl(navController)
        PanelResult()
    }
}