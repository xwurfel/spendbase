package com.ilnytskyi.spendbase.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ilnytskyi.spendbase.ui.home.card_details_screen.components.CardDetailsScreen
import com.ilnytskyi.spendbase.ui.home.home_screen.HomeEvent
import com.ilnytskyi.spendbase.ui.home.home_screen.HomeState
import com.ilnytskyi.spendbase.ui.navigation.BottomNavItem

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel(), paddingValues: PaddingValues
) {
    val navController: NavHostController = rememberNavController()

    val uiState by viewModel.stateFlow.collectAsStateWithLifecycle(HomeState())

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.SelectCard -> {
                uiState.selectedCardId = event.cardId
                navController.navigate(HomeNavGraph.Cards.route)
            }

            is HomeEvent.SelectTransaction -> {
                uiState.selectedTransactionId = event.transactionId
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = HomeNavGraph.Home.route,
        route = BottomNavItem.Home.route
    ) {
        composable(HomeNavGraph.Home.route) {
            HomeScreen(uiState, { action -> onEvent(action) }, paddingValues)
        }

        composable(HomeNavGraph.Cards.route) {

            val card = uiState.cards.firstOrNull { it.id == uiState.selectedCardId }

            if (card == null) {
                navController.navigate(HomeNavGraph.Home.route)

            } else CardDetailsScreen(
                card = card, transactions = uiState.transactions.filter {
                    it.card?.id == uiState.selectedCardId
                }, paddingValues = paddingValues
            ) {
                navController.popBackStack()
            }
        }
    }
}

sealed class HomeNavGraph(val route: String) {
    object Home : HomeNavGraph("main")
    object Cards : HomeNavGraph("cards")
}
