package com.android.platebuddy.platebuddyapp.main

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import com.android.platebuddy.platebuddyapp.R
import com.android.platebuddy.platebuddyapp.main.ui.calculator.PlateCalculatorFragment
import com.android.platebuddy.platebuddyapp.main.ui.platemanagement.PlateManagementFragment
import kotlinx.android.synthetic.main.activity_main.*

class PlateBuddyMainActivity : AppCompatActivity() {

    //todo replate with navigation component
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_calculator -> {
                updateFragment(PlateCalculatorFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_plate_manage -> {
                updateFragment(PlateManagementFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        if(supportFragmentManager.backStackEntryCount == 0) {
            updateFragment(PlateCalculatorFragment.newInstance())
        }
    }

    private fun updateFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
