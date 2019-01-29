package com.android.platebuddy.platebuddyapp.main.ui.calculator

import android.app.AlertDialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.TextViewCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.android.platebuddy.platebuddyapp.R
import com.android.platebuddy.platebuddyapp.models.PlateResult
import kotlinx.android.synthetic.main.fragment_plate_calculator.*


class PlateCalculatorFragment: Fragment() {

    private lateinit var viewModel: PlateCalculatorViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_plate_calculator, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PlateCalculatorViewModel::class.java)
        viewModel.getPlateResult().observe(this, Observer<PlateResult>{ plateResult ->
            displayResults(plateResult!!)
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        btnCalculate.setOnClickListener {
            val weightToLift = weightToLiftEditTxt.text.toString().toFloat()
            val barWeight = getBarWeight()
            val plateResult = viewModel.calculatePlateResult(barWeight, weightToLift)
            viewModel.setPlateResult(plateResult)
        }
    }

    private fun displayResults(plateResult: PlateResult) {
        plateResult.plates.forEach {
            val plateDisplay = it.count.toString() + " " + it.weight + " plates"
            val tvPlateDisplay = TextView(this.context)
            tvPlateDisplay.text = plateDisplay
            TextViewCompat.setTextAppearance(tvPlateDisplay, R.style.TextAppearance_MaterialComponents_Headline5)
            ll_plate_display.addView(tvPlateDisplay)
        }
    }

    private fun getBarWeight(): Float {
        val currentBarWeightId = barWeightRadioGrp.checkedRadioButtonId
        if(currentBarWeightId == R.id.barWeight45RadioBtn) {
            return 45.0f
        }
        return 35.0f
    }
}