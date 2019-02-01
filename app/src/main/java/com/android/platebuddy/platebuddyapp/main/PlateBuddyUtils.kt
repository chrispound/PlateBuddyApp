package com.android.platebuddy.platebuddyapp.main

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlin.math.floor


fun Float.divisibleCount(x: Float): Int {
    return floor(this/x).toInt()
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}