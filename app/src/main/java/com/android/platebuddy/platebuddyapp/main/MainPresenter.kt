package com.android.platebuddy.platebuddyapp.main

import com.android.platebuddy.platebuddyapp.models.PlateResult

class MainPresenter {
    fun calculatePlateResult(weightToLife: Int): PlateResult {
        return PlateResult(0,0,0,0,0)
    }
}