package com.example.pairclinic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pairclinic.presentation.NavGraphs
import com.example.pairclinic.presentation.ui.theme.PairClinicTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            val viewModel: ViewModelBookingScreen by viewModels()     //working but no needed rn

            PairClinicTheme {

                DestinationsNavHost(navGraph = NavGraphs.root)

                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    ToDisplayScaffold()
//                }
            }
        }
    }
}
