package com.example.pairclinic.presentation.conflict_screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun ConflictScreen(){
    Text(text = "Conflict Screen", fontSize = 25.sp, textAlign = TextAlign.Center)
}