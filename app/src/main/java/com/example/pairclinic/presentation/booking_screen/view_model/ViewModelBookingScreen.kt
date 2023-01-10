package com.example.pairclinic.presentation.booking_screen.view_model

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ViewModelBookingScreen @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun addToNotRes() {
        uiState.value.checkboxCounterNotReserved++
        if (uiState.value.checkboxCounterNotReserved > 0) {
            _uiState.update { it.copy(checkboxCounterNotReserved = uiState.value.checkboxCounterNotReserved++) }
        }
    }

    fun removeFromNotRes() {

        uiState.value.checkboxCounterNotReserved--
        if (uiState.value.checkboxCounterNotReserved == 0) {
            _uiState.update { it.copy(checkboxCounterNotReserved = uiState.value.checkboxCounterNotReserved--) }
        }

    }

    fun addToRes() {
        uiState.value.checkboxCounterReserved++
        if (uiState.value.checkboxCounterReserved > 0) {
            _uiState.update { it.copy(checkboxCounterReserved = uiState.value.checkboxCounterReserved++) }
        }
    }

    fun removeFromRes() {

        uiState.value.checkboxCounterReserved--
        if (uiState.value.checkboxCounterReserved == 0) {
            _uiState.update { it.copy(checkboxCounterReserved = uiState.value.checkboxCounterReserved--) }
        }

    }

    fun snackAppear() {

        if (!uiState.value.snackBarStateBooking) {
            _uiState.update { it.copy(snackBarStateBooking = true) }
        }

    }

    fun snackDisappear() {

        if (uiState.value.snackBarStateBooking) {
            _uiState.update { it.copy(snackBarStateBooking = false) }
        }

    }

    fun resetValues() {
        uiState.value.checkboxCounterReserved = 0
        uiState.value.checkboxCounterNotReserved = 0

        if (uiState.value.checkboxCounterNotReserved > 0) {
            _uiState.update {
                it.copy(checkboxCounterNotReserved = 0)
                it.copy(checkboxCounterReserved = 0)
            }
        }

    }
}
