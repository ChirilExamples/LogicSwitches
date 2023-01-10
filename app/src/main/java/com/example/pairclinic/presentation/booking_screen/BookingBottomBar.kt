package com.example.pairclinic.presentation.booking_screen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pairclinic.presentation.booking_screen.view_model.ViewModelBookingScreen
import com.example.pairclinic.presentation.destinations.ConfirmationScreenDestination
import com.example.pairclinic.presentation.destinations.ConflictScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun BookingBottomBarContent(viewModel: ViewModelBookingScreen, navigator: DestinationsNavigator) {

    BottomAppBar(
        modifier = Modifier
            .background(Color.Transparent)
            .height(130.dp)
    ) {

        val uiState by viewModel.uiState.collectAsState()

        Column {
            val context = LocalContext.current
            Achtung()
            Button(
                onClick = {
                    if (uiState.checkboxCounterReserved != 0 && uiState.checkboxCounterNotReserved != 0) {
                        navigator.navigate(ConflictScreenDestination)
                        Toast.makeText(context, " To Conflict Screen", Toast.LENGTH_SHORT)
                            .show()
                        viewModel.resetValues()
                    } else if (uiState.checkboxCounterReserved != 0) {
                        navigator.navigate(ConfirmationScreenDestination)
                        Toast.makeText(context, " To Confirmation Screen", Toast.LENGTH_SHORT)
                            .show()
                        viewModel.resetValues()
                    } else if (uiState.checkboxCounterReserved == 0) {
                        viewModel.snackAppear()
                    }

                },
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxWidth(),
                enabled = ((uiState.checkboxCounterNotReserved > 0) || (uiState.checkboxCounterReserved > 0))
            ) {
                Text(text = "Continue", fontSize = 16.sp)
            }
        }

    }
}

@Composable
fun Achtung() {
    Row {
        Icon(
            Icons.Default.Info,
            contentDescription = "Close, reservation needed, pop up",
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        Text(
            text = "At least one Guest in the party must have a reservation. Guests without reservations must remain in the same booking party in order to enter.",
            fontSize = 14.sp
        )
    }
}
