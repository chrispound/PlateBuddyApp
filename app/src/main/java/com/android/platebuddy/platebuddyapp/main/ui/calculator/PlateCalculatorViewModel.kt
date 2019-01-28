package com.android.platebuddy.platebuddyapp.main.ui.calculator

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
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
}