package com.example.pairclinic.presentation.booking_screen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pairclinic.presentation.booking_screen.view_model.ViewModelBookingScreen

@Composable
fun ContentMain(viewModel: ViewModelBookingScreen) {

    Column {
        Spacer(modifier = Modifier.height(20.dp))
        CatHeader(text = "These Guests Have Reservations")
        Spacer(modifier = Modifier.height(5.dp))
        LazyColumnReserved(0.45f, viewModel)
        Spacer(modifier = Modifier.height(18.dp))
        CatHeader(text = "These Guests Need Reservations")
        Spacer(modifier = Modifier.height(5.dp))
        LazyColumnNotReserved(1f, viewModel)

        Spacer(modifier = Modifier.height(8.dp))

    }

}


@Composable
fun CatHeader(text: String) {
    Text(text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .semantics { heading() })
}

@Composable
fun LazyColumnReserved(size: Float, viewmodel: ViewModelBookingScreen) {

    val list = listOf(
        "Kyree Ridgeway",
        "Rebeca Wilhelm",
        "Tierra Peyton",
        "Gabriel Hebert",
        "Ibrahim Burdick",
        "Helen Weiner",
        "Marvin Batchelor",
        "Kiera Pollard",
        "Truman Kessler",
        "Ammon Portillo"
    )
    LazyColumn(modifier = Modifier.fillMaxHeight(size)) {
        items(items = list, itemContent = { item ->
            val checkedState = remember { mutableStateOf(false) }
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .semantics(mergeDescendants = true) {}
                    .clearAndSetSemantics {
                        contentDescription =
                            "$item, checkbox is set to, ${checkedState.value}; double tap to toggle"
                    }
                    .toggleable(value = checkedState.value, onValueChange = {
                        checkedState.value = it
                        if (it) {
                            viewmodel.addToRes()
                        } else {
                            viewmodel.removeFromRes()
                        }
                        Log.i(
                            "checkboxCounterReserved",
                            viewmodel.uiState.value.checkboxCounterReserved.toString()
                        )
                    })
            ) {

                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = {
                        checkedState.value = it
                        if (it) {
                            viewmodel.addToRes()
                        } else {
                            viewmodel.removeFromRes()
                        }
                        Log.i(
                            "checkboxCounterReserved",
                            viewmodel.uiState.value.checkboxCounterReserved.toString()
                        )
                    },

                    )
                Text(
                    text = item,
                    maxLines = 2,
                )
            }
        })
    }
}

@Composable
fun LazyColumnNotReserved(size: Float, viewmodel: ViewModelBookingScreen) {
    val list = listOf(
        "Kyree Second Ridgeway",
        "Rebeca Second Wilhelm",
        "Tierra Second Peyton",
        "Gabriel Second Hebert",
        "Ibrahim Second Burdick",
        "Helen Second Weiner",
        "Marvin Second Batchelor",
        "Kiera Second Pollard",
        "Truman Second Kessler",
        "Ammon Second Portillo"
    )
    LazyColumn(modifier = Modifier.fillMaxHeight(size)) {
        items(items = list, itemContent = { item ->
            val checkedState = remember { mutableStateOf(false) }
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .semantics(mergeDescendants = true) {}
                    .clearAndSetSemantics {
                        contentDescription =
                            "$item, checkbox is set to, ${checkedState.value}; double tap to toggle"
                    }
                    .toggleable(value = checkedState.value, onValueChange = {
                        checkedState.value = it
                        if (it) {
                            viewmodel.addToNotRes()
                        } else {
                            viewmodel.removeFromNotRes()
                        }
                        Log.i(
                            "checkboxCounterReserved",
                            viewmodel.uiState.value.checkboxCounterNotReserved.toString()
                        )
                    })
            ) {
                Checkbox(checked = checkedState.value, onCheckedChange = {
                    checkedState.value = it
                    if (it) {
                        viewmodel.addToNotRes()
                    } else {
                        viewmodel.removeFromNotRes()
                    }
                    Log.i(
                        "checkboxCounterReserved",
                        viewmodel.uiState.value.checkboxCounterNotReserved.toString()
                    )
                })
                Text(
                    text = item, maxLines = 2
                )
            }
        })
    }
}
