package com.example.hw2_androidstudio.viewmodel

data class CalculatorUiState(
    val totalInput: String = "",
    val peopleInput: String = "",
    val tipInput: String = "",
    val isInputValid: Boolean = false
)