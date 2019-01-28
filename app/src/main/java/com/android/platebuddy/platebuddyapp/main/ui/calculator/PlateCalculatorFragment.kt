package com.android.platebuddy.platebuddyapp.main.ui.calculator

import android.app.AlertDialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.platebuddy.platebuddyapp.R
import com.android.platebuddy.platebuddyapp.main.MainPresenter
import com.android.platebuddy.platebuddyapp.main.ui.platemanagement.PlateManagementViewModel
import com.android.platebuddy.platebuddyapp.models.Plate
import com.android.platebuddy.platebuddyapp.models.PlateResult
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.plate_management_fragment.*


class PlateCalculatorFragment: Fragment() {

    private val presenter = MainPresenter()
    private lateinit var viewModel: PlateCalculatorViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PlateCalculatorViewModel::class.java)
        viewModel.getPlateResult().observe(this, Observer<PlateResult>{ plateResult ->
            displayResults(plateResult!!)
            //todo update ui
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
            val plateResult = presenter.calculatePlateResult(barWeight, weightToLift)
            viewModel.setPlateResult(plateResult)
        }
    }

    private fun displayResults(plateResult: PlateResult) {
        val dialog = AlertDialog.Builder(this.context)
        dialog
            .setTitle("Plates To Use")
            .setMessage(plateResult.toString())
         dialog.show()
    }

    private fun getBarWeight(): Float {
        val currentBarWeightId = barWeightRadioGrp.checkedRadioButtonId
        if(currentBarWeightId == R.id.barWeight45RadioBtn) {
            return 45.0f
        }
        return 35.0f
    }
}