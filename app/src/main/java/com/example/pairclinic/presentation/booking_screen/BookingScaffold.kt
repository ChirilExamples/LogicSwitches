package com.example.pairclinic.presentation.booking_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pairclinic.presentation.booking_screen.view_model.ViewModelBookingScreen
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@OptIn(ExperimentalMaterial3Api::class)
@RootNavGraph(start = true)
@Destination
@Composable
fun ToDisplayScaffold(
    viewModel: ViewModelBookingScreen = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    Scaffold(
        topBar = {
            BookingAppBar()
        },

        content = {

            Column(modifier = Modifier.padding(it)) {
                ContentMain(viewModel)

            }
        },
        bottomBar = {
            BookingBottomBarContent(viewModel, navigator)
            ReservationNeeded(viewModel)
        }
    )
}
