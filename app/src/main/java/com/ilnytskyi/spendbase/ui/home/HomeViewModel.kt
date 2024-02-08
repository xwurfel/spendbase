package com.ilnytskyi.spendbase.ui.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class HomeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _stateFlow: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())

    val stateFlow: StateFlow<HomeState> = _stateFlow.asStateFlow()

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.SelectCard -> {

            }
            is HomeEvent.SelectTransaction -> {

            }
        }
    }
}