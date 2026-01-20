package com.example.hw2_androidstudio.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import com.example.hw2_androidstudio.viewmodel.CalculatorViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue


@Composable
fun InputScreen(
    viewModel: CalculatorViewModel,
    onCalculate: (Int) -> Unit
) {
    val state by viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text("Введите детали чека", fontSize = 24.sp)

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = state.totalInput,
                onValueChange = { viewModel.onTotalChanged(it) },
                label = { Text("Сумма чека") }
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = state.peopleInput,
                onValueChange = { viewModel.onPeopleChanged(it) },
                label = { Text("Количество людей") }
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = state.tipInput,
                onValueChange = { viewModel.onTipChanged(it) },
                label = { Text("Чаевые") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val id = viewModel.calculate()
                    onCalculate(id)
                },
                enabled = state.isInputValid
            ) {
                Text("Рассчитать")
            }
        }
    }
}