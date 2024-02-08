package com.ilnytskyi.spendbase.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.ilnytskyi.spendbase.domain.model.card.Card
import com.ilnytskyi.spendbase.domain.model.card.CardHolder
import com.ilnytskyi.spendbase.ui.home.home_screen.HomeEvent
import com.ilnytskyi.spendbase.ui.home.home_screen.HomeState
import com.ilnytskyi.spendbase.ui.home.home_screen.components.HomeAvailableBalance
import com.ilnytskyi.spendbase.ui.home.home_screen.components.HomeMyCards
import com.ilnytskyi.spendbase.ui.home.home_screen.components.HomeRecentTransactions
import com.ilnytskyi.spendbase.ui.home.home_screen.components.HomeTopBar
import com.ilnytskyi.spendbase.ui.home.home_screen.components.mockTransaction
import com.ilnytskyi.spendbase.ui.theme.Neutral200

@Composable
fun HomeScreen(
    state: HomeState,
    actions: (HomeEvent) -> Unit,
    paddingValues: PaddingValues = PaddingValues(0.dp)
) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            ,
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)

        ) {
            Spacer(modifier = Modifier.height(16.dp))
            HomeTopBar(homeEvent = {})
            Divider(
                modifier = Modifier.padding(top = 8.dp), color = Neutral200
            )
            Spacer(modifier = Modifier.height(24.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                HomeAvailableBalance(
                    Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                )

                if (!state.isCardsLoading)
                    HomeMyCards(cards = state.cards.take(3)){
                        actions(HomeEvent.SelectCard(it))
                    }

                if (!state.isTransactionsLoading) {
                    HomeRecentTransactions(
                        transactions = state.transactions.take(3)
                    ){
                        actions(HomeEvent.SelectTransaction(it))
                    }
                }
            }

        }
    }

}

@Composable
@PreviewScreenSizes
@Preview(name = "Home")
private fun HomeScreenPreview() {
    HomeScreen(
        state = HomeState(
            cards = listOf(
                Card(
                    id = "1",
                    cardHolder = CardHolder(
                        email = "ad", fullName = "ad", logoUrl = "ad", id = "CDID"
                    ),
                    cardLast4 = "1234",
                    cardName = "Slack",
                    fundingSource = "Visa",
                    isLocked = false,
                    isTerminated = false,
                    issuedAt = "ada",
                    limit = 1000,
                    limitType = "limitType",
                    spent = 100,
                ), Card(
                    id = "1",
                    cardHolder = CardHolder(
                        email = "ad", fullName = "ad", logoUrl = "ad", id = "CDID"
                    ),
                    cardLast4 = "1234",
                    cardName = "Slack",
                    fundingSource = "Visa",
                    isLocked = false,
                    isTerminated = false,
                    issuedAt = "ada",
                    limit = 1000,
                    limitType = "limitType",
                    spent = 100,
                ), Card(
                    id = "1",
                    cardHolder = CardHolder(
                        email = "ad", fullName = "ad", logoUrl = "ad", id = "CDID"
                    ),
                    cardLast4 = "1234",
                    cardName = "Slack",
                    fundingSource = "Visa",
                    isLocked = false,
                    isTerminated = false,
                    issuedAt = "ada",
                    limit = 1000,
                    limitType = "limitType",
                    spent = 100,
                )
            ),
            transactions = listOf(
                mockTransaction,
                mockTransaction,
                mockTransaction,
                mockTransaction,
            )
        ),
        actions = {},
    )
}

