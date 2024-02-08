package com.ilnytskyi.spendbase.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ilnytskyi.spendbase.ui.home.HomeRoute
import com.ilnytskyi.spendbase.ui.not_implemented.NotImplementedScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RootNavGraph(rootNavController: NavHostController, paddingValues: PaddingValues) {
    NavHost(navController = rootNavController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            HomeRoute(paddingValues = paddingValues)
        }
        composable(BottomNavItem.Transactions.route) {
            NotImplementedScreen()
        }
        composable(BottomNavItem.MyCards.route) {
            NotImplementedScreen()
        }
        composable(BottomNavItem.Account.route) {
            NotImplementedScreen()
        }
    }
}