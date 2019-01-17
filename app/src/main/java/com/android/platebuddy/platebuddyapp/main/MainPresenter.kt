package com.android.platebuddy.platebuddyapp.main

import com.android.platebuddy.platebuddyapp.models.Plate
import com.android.platebuddy.platebuddyapp.models.PlateResult
import kotlin.math.floor

class MainPresenter {

    //todo Generalize to support different weights
    //todo move from static plates to user managed plates
    //todo If the plate count is 0 should is it worth adding to result?
    fun calculatePlateResult(barWeight: Float, weightToLift: Float): PlateResult {
        val plates = ArrayList<Plate>()
        val plateWeights = arrayOf(45f, 35f, 25f, 10f, 5f, 2.5f)
        var weightToLiftCurrent = (weightToLift - barWeight) / 2
        for(plateWeight in plateWeights) {
            val result = buildPlate(weightToLiftCurrent, plateWeight)
            plates.add(result.first)
            weightToLiftCurrent = result.second
        }
        return PlateResult(plates)
    }

    private fun buildPlate(weightToLift: Float, plateWeight: Float): Pair<Plate, Float> {
        val plate = Plate(plateWeight, weightToLift.divisibleCount(plateWeight))
        return Pair(plate, weightToLift - (plate.weight * plate.count))
    }
}

fun Float.divisibleCount(x: Float): Int {
    return floor(this/x).toInt()
}