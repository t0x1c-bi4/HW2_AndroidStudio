package com.example.hw2_androidstudio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hw2_androidstudio.navigation.AppNavigation
import com.example.hw2_androidstudio.ui.theme.HW2_AndroidStudioTheme
import com.example.hw2_androidstudio.viewmodel.CalculatorViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            HW2_AndroidStudioTheme {

                val viewModel: CalculatorViewModel = viewModel()

                AppNavigation(viewModel = viewModel)
            }
        }
    }
}