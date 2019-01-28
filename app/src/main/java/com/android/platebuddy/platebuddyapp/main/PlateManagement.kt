package com.android.platebuddy.platebuddyapp.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.platebuddy.platebuddyapp.R
import com.android.platebuddy.platebuddyapp.main.ui.platemanagement.PlateManagementFragment

class PlateManagement : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.plate_management_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PlateManagementFragment.newInstance())
                .commitNow()
        }
    }

}
