package com.android.platebuddy.platebuddyapp.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.platebuddy.platebuddyapp.R
import kotlinx.android.synthetic.main.*
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun setupView() {
        btnCalculate.setOnClickListener {

        }
    }
}