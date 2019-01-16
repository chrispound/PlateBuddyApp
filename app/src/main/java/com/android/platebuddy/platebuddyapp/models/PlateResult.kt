package com.android.platebuddy.platebuddyapp.models

/**
 * Result of the total number of plates needed for the given weight.
 */
data class PlateResult ( val numOf45: Int,
                    val numOf35: Int,
                    val numOf10: Int,
                    val numOf5: Int,
                    val numOf2_5: Int)