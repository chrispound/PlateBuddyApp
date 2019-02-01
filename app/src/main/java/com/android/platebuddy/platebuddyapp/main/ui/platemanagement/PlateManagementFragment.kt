package com.android.platebuddy.platebuddyapp.main.ui.platemanagement

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.platebuddy.platebuddyapp.R

class PlateManagementFragment : Fragment() {

    companion object {
        fun newInstance() = PlateManagementFragment()
    }

    private lateinit var viewModel: PlateManagementViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_plate_management, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PlateManagementViewModel::class.java)
    }

}
