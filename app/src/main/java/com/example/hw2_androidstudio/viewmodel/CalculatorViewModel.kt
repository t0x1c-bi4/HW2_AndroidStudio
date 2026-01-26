package com.example.hw2_androidstudio.viewmodel

import androidx.lifecycle.ViewModel
import com.example.hw2_androidstudio.data.Calculation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CalculatorViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CalculatorUiState())
    val uiState: StateFlow<CalculatorUiState> = _uiState

    private val history = mutableListOf<Calculation>()
    private var nextId = 0

    fun onTotalChanged(value: String) {
        _uiState.value = _uiState.value.copy(
            totalInput = value,
            isInputValid = isValid(value, _uiState.value.peopleInput, _uiState.value.tipInput)
        )
    }

    fun onPeopleChanged(value: String) {
        _uiState.value = _uiState.value.copy(
            peopleInput = value,
            isInputValid = isValid(_uiState.value.totalInput, value, _uiState.value.tipInput)
        )
    }

    fun onTipChanged(value: String) {
        _uiState.value = _uiState.value.copy(
            tipInput = value,
            isInputValid = isValid(
                _uiState.value.totalInput,
                _uiState.value.peopleInput,
                value
            )
        )
    }

    private fun isValid(total: String, people: String, tip: String): Boolean {
        val t = total.toDoubleOrNull()
        val p = people.toIntOrNull()
        val ti = tip.toDoubleOrNull()
        return t != null && t > 0 &&
               p != null && p > 0 &&
               ti != null && ti >= 0
    }

    fun calculate(): Int {
        val total = _uiState.value.totalInput.toDouble()
        val people = _uiState.value.peopleInput.toInt()
        val tip = _uiState.value.tipInput.toInt()

        val totalWithTip = total + tip
        val perPerson = totalWithTip / people

        fun round2(value: Double): Double =
            String.format("%.2f", value).replace(",", ".").toDouble()

        val calc = Calculation(
            id = nextId++,
            total = round2(total),
            people = people,
            tip = tip,
            totalWithTip = round2(totalWithTip),
            perPerson = round2(perPerson)
        )

        history.add(0, calc)
        if (history.size > 5) history.removeAt(history.lastIndex)

        return calc.id
    }

    fun getCalculation(id: Int): Calculation? =
        history.find { it.id == id }

    fun getHistory(): List<Calculation> = history

    fun reset() {
        _uiState.value = CalculatorUiState()
    }
}