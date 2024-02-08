package com.ilnytskyi.spendbase.ui.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilnytskyi.spendbase.domain.use_cases.card.GetCardsUseCase
import com.ilnytskyi.spendbase.domain.use_cases.transaction.GetTransactionsUseCase
import com.ilnytskyi.spendbase.domain.util.Resource
import com.ilnytskyi.spendbase.ui.home.home_screen.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getCardsUseCase: GetCardsUseCase,
    private val getTransactionsUseCase: GetTransactionsUseCase
) : ViewModel() {

    private val _stateFlow: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())

    val stateFlow: StateFlow<HomeState> = _stateFlow.asStateFlow()

    init {
        collectCards()
        collectTransactions()
    }

    private fun collectCards() {
        viewModelScope.launch {
            getCardsUseCase().collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _stateFlow.update {
                            it.copy(isCardsLoading = true)
                        }
                    }
                    is Resource.Success -> {
                        _stateFlow.update {
                            it.copy(cards = resource.data ?: emptyList(), isCardsLoading = false, error = "")
                        }
                    }
                    is Resource.Error -> {
                        _stateFlow.update {
                            it.copy(error = resource.message ?: "", isCardsLoading = false)
                        }
                    }
                }
            }
        }
    }

    private fun collectTransactions() {
        viewModelScope.launch {
            getTransactionsUseCase().collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _stateFlow.update {
                            it.copy(isTransactionsLoading = true)
                        }
                    }
                    is Resource.Success -> {
                        _stateFlow.update {
                            it.copy(transactions = resource.data ?: emptyList(), isTransactionsLoading = false, error = "")
                        }
                    }
                    is Resource.Error -> {
                        _stateFlow.update {
                            it.copy(error = resource.message ?: "", isTransactionsLoading = false)
                        }
                    }
                }
            }
        }
    }
}