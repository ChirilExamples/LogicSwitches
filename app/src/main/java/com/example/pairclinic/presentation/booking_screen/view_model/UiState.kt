package com.example.pairclinic.presentation.booking_screen.view_model

data class UiState(
    var snackBarStateBooking:Boolean=false,
    var checkboxCounterReserved:Int=0,
    var checkboxCounterNotReserved:Int=0,
    val guestNeedReservation:Boolean=false,
    val guestHaveReservation:Boolean=false,

    )