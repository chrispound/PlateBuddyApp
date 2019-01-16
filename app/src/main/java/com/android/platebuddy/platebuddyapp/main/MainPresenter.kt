package com.android.platebuddy.platebuddyapp.main

import com.android.platebuddy.platebuddyapp.models.PlateResult
import kotlin.math.floor

class MainPresenter {
    //todo  Generalize to support different weights
    fun calculatePlateResult(barWeight: Float, weightToLift: Float): PlateResult {
        var weightToLiftCurrent = (weightToLift - barWeight) / 2
        val numOf45 = weightToLiftCurrent.divisibleCount(45.0f)
        weightToLiftCurrent -= 45 * numOf45
        val numOf35 = weightToLiftCurrent.divisibleCount(35.0f)
        weightToLiftCurrent  -= 35 * numOf35
        val numOf10 = weightToLiftCurrent.divisibleCount(10.0f)
        weightToLiftCurrent  -= 10 * numOf10
        val numOf5 = weightToLiftCurrent.divisibleCount(5.0f)
        weightToLiftCurrent  -= 5 * numOf5
        val numOfTwoAndHalf = weightToLiftCurrent.divisibleCount(2.5f)
        weightToLiftCurrent  -= 2.5f * numOfTwoAndHalf
        return PlateResult(numOf45, numOf35, numOf10, numOf5, numOfTwoAndHalf)
    }
}

fun Float.divisibleCount(x: Float): Int {
    return floor(this/x).toInt()
}