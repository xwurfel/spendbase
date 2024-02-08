package com.ilnytskyi.spendbase.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    state: HomeState,
    actions: (HomeEvent) -> Unit,
    paddingValues: PaddingValues = PaddingValues(0.dp)
) {


}

@Composable
@Preview(name = "Home")
private fun HomeScreenPreview() {
    HomeScreen(
        state = HomeState(),
        actions = {},
    )
}

