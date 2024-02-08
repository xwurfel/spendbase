package com.ilnytskyi.spendbase.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.Scaffold
import androidx.navigation.compose.rememberNavController
import com.ilnytskyi.spendbase.ui.navigation.BottomNavigation
import com.ilnytskyi.spendbase.ui.navigation.RootNavGraph
import com.ilnytskyi.spendbase.ui.theme.SpendbaseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpendbaseTheme {
                val navController = rememberNavController()
                Scaffold(bottomBar = {
                    BottomNavigation(navController = navController)
                }) { paddingValues ->
                    RootNavGraph(navController = navController, paddingValues = paddingValues)
                }
            }
        }
    }
}
