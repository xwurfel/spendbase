package com.ilnytskyi.spendbase.ui.home


/**
 * UI State that represents HomeScreen
 **/
class HomeState

/**
 * Home Actions emitted from the UI Layer
 **/
sealed class HomeEvent {
    class SelectCard(val cardId: String) : HomeEvent()
    class SelectTransaction(val transactionId: String) : HomeEvent()
}