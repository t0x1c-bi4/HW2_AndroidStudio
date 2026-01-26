package com.example.hw2_androidstudio.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    onStart: () -> Unit,
    onHistory: () -> Unit
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text("Давай поделим чек", fontSize = 32.sp)

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = onStart) { Text("Начать") }
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = onHistory) { Text("История") }
        }
    }
}