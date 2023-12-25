package com.killer.converter.infrastructure.ui.router

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.killer.converter.infrastructure.ui.ConverterPage
import com.killer.converter.infrastructure.ui.HistoryPage

@Composable
fun Router(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "converter") {
        composable("converter") { ConverterPage(navController) }
        composable("history") { HistoryPage() }
    }
}