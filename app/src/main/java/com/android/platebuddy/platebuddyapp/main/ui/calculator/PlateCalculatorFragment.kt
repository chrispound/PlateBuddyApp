package com.android.platebuddy.platebuddyapp.main.ui.calculator

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.platebuddy.platebuddyapp.R
import com.android.platebuddy.platebuddyapp.models.PlateResult
import kotlinx.android.synthetic.main.fragment_plate_calculator.*


class PlateCalculatorFragment : Fragment() {

    private lateinit var viewModel: PlateCalculatorViewModel
    private val viewAdapter = PlateWeightsAdapter()
    private lateinit var viewManager: RecyclerView.LayoutManager;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_plate_calculator, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PlateCalculatorViewModel::class.java)
        viewModel.getPlateResult().observe(this, Observer<PlateResult> { plateResult ->
            viewAdapter.plates = plateResult?.plates ?: emptyList()
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        viewManager = LinearLayoutManager(context)
        btnCalculate.setOnClickListener {
            val weightToLift = weightToLiftEditTxt.text.toString().toFloat()
            val barWeight = getBarWeight()
            val plateResult = viewModel.calculatePlateResult(barWeight, weightToLift)
            viewModel.setPlateResult(plateResult)
        }

        relativeLayoutPlates.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    private fun getBarWeight(): Float {
        val currentBarWeightId = barWeightRadioGrp.checkedRadioButtonId
        if (currentBarWeightId == R.id.barWeight45RadioBtn) {
            return 45.0f
        }
        return 35.0f
    }
}