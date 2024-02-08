package com.ilnytskyi.spendbase.ui.home.home_screen

import com.ilnytskyi.spendbase.domain.model.card.Card
import com.ilnytskyi.spendbase.domain.model.transaction.Transaction


/**
 * UI State that represents HomeScreen
 **/
data class HomeState(
    val cards: List<Card> = emptyList(),
    val transactions: List<Transaction> = emptyList(),
    var selectedCardId: String? = null,
    var selectedTransactionId: String? = null,

    val isCardsLoading: Boolean = false,
    val isTransactionsLoading: Boolean = false,
    val error: String = ""
)

/**
 * Home Actions emitted from the UI Layer
 **/
sealed class HomeEvent {
    class SelectCard(val cardId: String) : HomeEvent()
    class SelectTransaction(val transactionId: String) : HomeEvent()
}