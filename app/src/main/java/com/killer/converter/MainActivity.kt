package com.killer.converter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import com.killer.converter.ui.widget.PanelBase
import com.killer.converter.ui.widget.PanelControl
import com.killer.converter.ui.widget.PanelInput
import com.killer.converter.ui.widget.PanelResult

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column() {
                PanelInput()
                PanelBase()
                PanelControl()
                PanelResult()
            }
        }
    }
}