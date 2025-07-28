package com.example.finalproject

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.math.log10
import kotlin.math.round

data class BodyFatCalculationState(
    val userGenderInput: String? = null,
    val userAgeInput: String? = null,
    val userWeightInput: String? = null,
    val userHeightInput: String? = null,
    val userNeckInput: String? = null,
    val userWaistInput: String? = null,
    val userHipInput: String? = null,
    val bfp: Double? = null,
    val totalBodyFatMass: Double? = null,
    val leanBodyMass: Double? = null,
    val errorMessage: String? = null,
    val submitButtonPressed: Boolean = false,
)

class BodyFatCalculationViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(BodyFatCalculationState())
    val uiState: StateFlow<BodyFatCalculationState> = _uiState.asStateFlow()

    fun updateSubmitButtonPressed() {
        _uiState.update {
            it.copy(submitButtonPressed = true)
        }
    }

    fun updateGender(gender: String) {
        _uiState.update {
            it.copy(userGenderInput = gender)
        }
    }

    fun updateAge(age: String) {
        _uiState.update {
            it.copy(userAgeInput = age)
        }
    }

    fun updateWeight(weight: String) {
        _uiState.update {
            it.copy(userWeightInput = weight)
        }
    }

    fun updateHeight(height: String) {
        _uiState.update {
            it.copy(userHeightInput = height)
        }
    }

    fun updateWaist(waist: String) {
        _uiState.update {
            it.copy(userWaistInput = waist)
        }
    }

    fun updateNeck(neck: String) {
        _uiState.update {
            it.copy(userNeckInput = neck)
        }
    }

    fun updateHip(hip: String) {
        _uiState.update {
            it.copy(userHipInput = hip)
        }
    }


    fun isNumberInvalidOrLessThan0(number: Double?): Boolean {
        return (number == null || number <= 0.0)
    }


    fun maleBodyFatCalculation(currentState: BodyFatCalculationState): Double? {
        val waistCm: Double? = currentState.userWaistInput?.toDoubleOrNull()
        val neckCm: Double? = currentState.userNeckInput?.toDoubleOrNull()
        val heightCm: Double? = currentState.userHeightInput?.toDoubleOrNull()

        if (isNumberInvalidOrLessThan0(waistCm) || isNumberInvalidOrLessThan0(neckCm) || isNumberInvalidOrLessThan0(
                heightCm
            )
        ) {
            return null
        }

        val validWaist = waistCm!!
        val validNeck = neckCm!!
        val validHeight = heightCm!!

        val waistNeckDiff = validWaist - validNeck

        if (waistNeckDiff <= 0) {
            return null
        }
        return 86.010 * log10(waistNeckDiff) - 70.041 * log10(validHeight) + 36.76
    }

    fun femaleBodyFatCalculation(currentState: BodyFatCalculationState): Double? {

        val waistCm: Double? = currentState.userWaistInput?.toDoubleOrNull()
        val neckCm: Double? = currentState.userNeckInput?.toDoubleOrNull()
        val heightCm: Double? = currentState.userHeightInput?.toDoubleOrNull()
        val hipCm: Double? = currentState.userHipInput?.toDoubleOrNull()


        if (isNumberInvalidOrLessThan0(waistCm) || isNumberInvalidOrLessThan0(neckCm) || isNumberInvalidOrLessThan0(heightCm) || isNumberInvalidOrLessThan0(hipCm)
        ) {
            return null
        }

        val validWaist = waistCm!!
        val validNeck = neckCm!!
        val validHeight = heightCm!!
        val validHip = hipCm!!

        val sum = validWaist + validHip - validNeck

        if (sum <= 0) {
            return null
        }
        return 163.205 * log10(sum) - 97.684 * log10(validHeight) - 78.387
    }


    fun calculateBodyFatPercentageSwitch() {
        _uiState.update { currentState ->
            val userGenderInput = currentState.userGenderInput
            var calculatedBfp: Double? = null
            var currentErrorMessage: String? = null

            when (userGenderInput) {
                "female" -> {
                    calculatedBfp = femaleBodyFatCalculation(currentState)
                    if (calculatedBfp == null) {
                        currentErrorMessage = "Invalid input"
                    }
                }

                "male" -> {
                    calculatedBfp = maleBodyFatCalculation(currentState)
                    if (calculatedBfp == null) {
                        currentErrorMessage = "Invalid input"
                    }
                }
                else -> {
                    currentErrorMessage = "Invalid input"
                }
            }

            val finalBfp: Double? = calculatedBfp?.let { round(it * 100.0)/100.0 }

            var newTotalBodyFatMass: Double? = null
            var newLeanBodyMass: Double? = null

            if (finalBfp != null) {
                val totalWeight = currentState.userWeightInput?.toDoubleOrNull()!!
                newTotalBodyFatMass = totalWeight.times(finalBfp.div(100))
                newLeanBodyMass = totalWeight.minus(newTotalBodyFatMass!!)
            }

            currentState.copy(bfp = round(calculatedBfp ?: 0.0), errorMessage = currentErrorMessage, totalBodyFatMass = newTotalBodyFatMass, leanBodyMass = newLeanBodyMass)
        }
    }

}







