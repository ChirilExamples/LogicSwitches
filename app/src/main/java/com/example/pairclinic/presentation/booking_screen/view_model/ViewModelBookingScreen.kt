package com.example.pairclinic.presentation.booking_screen.view_model

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ViewModelBookingScreen : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun addToNotRes() {
        uiState.value.checkboxCounterNotReserved++
        if (uiState.value.checkboxCounterNotReserved > 0) {
            _uiState.update { it.copy(guestNeedReservation = true) }
        }
    }

    fun removeFromNotRes() {

        uiState.value.checkboxCounterNotReserved--
        if (uiState.value.checkboxCounterNotReserved == 0) {
            _uiState.update { it.copy(guestNeedReservation = false) }
        }

    }

    fun addToRes() {
        uiState.value.checkboxCounterReserved++
        if (uiState.value.checkboxCounterReserved > 0) {
            _uiState.update { it.copy(guestHaveReservation = true) }
        }
    }

    fun removeFromRes() {

        uiState.value.checkboxCounterReserved--
        if (uiState.value.checkboxCounterReserved == 0) {
            _uiState.update { it.copy(guestHaveReservation = false) }
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

}