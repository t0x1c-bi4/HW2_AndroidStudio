package com.example.hw2_androidstudio.data

data class Calculation(
    val id: Int,
    val total: Double,
    val people: Int,
    val tip: Int,
    val totalWithTip: Double,
    val perPerson: Double
)