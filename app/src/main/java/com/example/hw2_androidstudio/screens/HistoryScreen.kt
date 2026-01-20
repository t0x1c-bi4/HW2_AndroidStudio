package com.example.hw2_androidstudio.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.example.hw2_androidstudio.data.Calculation

@Composable
fun HistoryScreen(
    history: List<Calculation>,
    onBack: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text("История расчетов", fontSize = 28.sp)

            Spacer(modifier = Modifier.height(24.dp))

            history.forEach {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        Text(
                            text = "Сумма чека: ${it.total}"
                        )

                        Text(
                            text = "За каждого человека: ${it.perPerson}"
                        )

                        Text(
                            text = "Чаевые: ${it.tip}"
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = onBack) { Text("Назад") }
        }
    }
}