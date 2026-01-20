package com.example.hw2_androidstudio.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import com.example.hw2_androidstudio.data.Calculation

@Composable
fun ResultScreen(
    calculation: Calculation?,
    onBack: () -> Unit,
    onNew: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        if (calculation == null) return

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text("Итого", fontSize = 28.sp)

            Spacer(modifier = Modifier.height(24.dp))

            Text("Чаевые: ${calculation.tip}")
            Text("Счет с чаевыми: ${calculation.totalWithTip}")
            Text("За каждого человека: ${calculation.perPerson}")

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = onBack) { Text("Назад к редактированию") }
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = onNew) { Text("Назад на главный экран") }
        }
    }
}