package com.killer.converter.infrastructure

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.killer.converter.infrastructure.shared.DatabaseResults
import com.killer.converter.infrastructure.ui.router.Router

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DatabaseResults.initialize(applicationContext)

        setContent {
            Router()
        }
    }
}