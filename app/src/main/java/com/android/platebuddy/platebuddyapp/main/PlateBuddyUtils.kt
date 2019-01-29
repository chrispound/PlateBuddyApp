package com.android.platebuddy.platebuddyapp.main

import kotlin.math.floor


fun Float.divisibleCount(x: Float): Int {
    return floor(this/x).toInt()
}