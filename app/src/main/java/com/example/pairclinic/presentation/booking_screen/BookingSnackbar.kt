package com.example.pairclinic.presentation.booking_screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pairclinic.presentation.booking_screen.view_model.ViewModelBookingScreen

@Composable
fun ReservationNeeded(viewModel: ViewModelBookingScreen) {
    Column(verticalArrangement = Arrangement.Bottom) {

        val uiState by viewModel.uiState.collectAsState()

//        Button(
//            onClick = {
//                viewModel.snackAppear()
////                uiState.snackBarStateBooking =
////                    !uiState.snackBarStateBooking
//
//                Log.i(
//                    "snackBarStateBooking", viewModel.uiState.value.snackBarStateBooking.toString()
//                )
//            }, modifier = Modifier.padding(start = 300.dp)
//        ) {
//            if (uiState.snackBarStateBooking) {
//                Text("Hide snack Test")
//            } else {
//                Text("Show snack Test")
//            }
//        }
        if (uiState.snackBarStateBooking) {
            Snackbar(

                action = {
                    IconButton(onClick = {
                        viewModel.snackDisappear()
                        Log.i(
                            "snackBarStateBooking",
                            viewModel.uiState.value.snackBarStateBooking.toString()
                        )
                    }) {
                        Icon(
                            Icons.Filled.Done, contentDescription = "Close popup"
                        )
                    }
                }, modifier = Modifier.padding(8.dp)
            ) {
                Column {
                    Text(text = "Reservation Needed!", fontWeight = FontWeight.Bold)
                    Text(text = "Select at least one Guest that has a reservation to continue.")
                }
            }
        }
    }
}