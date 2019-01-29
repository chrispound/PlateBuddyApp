package com.android.platebuddy.platebuddyapp.main.ui.calculator

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.android.platebuddy.platebuddyapp.main.divisibleCount
import com.android.platebuddy.platebuddyapp.models.Plate
import com.android.platebuddy.platebuddyapp.models.PlateResult

class PlateCalculatorViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private var plateResult = MutableLiveData<PlateResult>()

    fun getPlateResult(): LiveData<PlateResult>{
        return  plateResult
    }

    fun setPlateResult(plateResult: PlateResult) {
        this.plateResult.value = plateResult
    }

    fun calculatePlateResult(barWeight: Float, weightToLift: Float): PlateResult {
        val plates = ArrayList<Plate>()
        val plateWeights = arrayOf(45f, 25f, 10f, 5f, 2.5f)
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