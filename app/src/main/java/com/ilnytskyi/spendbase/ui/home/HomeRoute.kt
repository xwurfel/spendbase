package com.ilnytskyi.spendbase.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel(),
    paddingValues: PaddingValues
) {
    val uiState by viewModel.stateFlow.collectAsStateWithLifecycle(HomeState())



    HomeScreen(uiState, viewModel::onEvent, paddingValues)
}
