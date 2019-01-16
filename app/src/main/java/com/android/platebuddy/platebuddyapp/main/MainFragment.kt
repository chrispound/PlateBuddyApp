package com.android.platebuddy.platebuddyapp.main

import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.platebuddy.platebuddyapp.R
import com.android.platebuddy.platebuddyapp.models.PlateResult
import kotlinx.android.synthetic.main.*
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment: Fragment() {

    val presenter = MainPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    fun setupView() {
        btnCalculate.setOnClickListener {
            val weightToLift = weightToLiftEditTxt.text.toString().toFloat()
            val barWeight = getBarWeight()
            val plateResult = presenter.calculatePlateResult(barWeight, weightToLift)
            displayResults(plateResult)
        }
    }

    fun displayResults(plateResult: PlateResult) {
        val dialog = AlertDialog.Builder(this.context)
        dialog
            .setTitle("Plates To Use")
            .setMessage(plateResult.toString())
         dialog.show()
    }

    fun getBarWeight(): Float {
        val currentBarWeightId = barWeightRadioGrp.checkedRadioButtonId
        if(currentBarWeightId == R.id.barWeight45RadioBtn) {
            return 45.0f
        }
        return 35.0f
    }
}