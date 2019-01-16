package com.android.platebuddy.platebuddyapp.main

import junit.framework.Assert.assertEquals
import org.junit.Test

class MainPresenterTests {

    @Test
    fun plateResultShouldBe0() {
       val plateResult = MainPresenter().calculatePlateResult(0)
        assertEquals(0, plateResult.numOf45)
        assertEquals(0, plateResult.numOf35)
        assertEquals(0, plateResult.numOf10)
        assertEquals(0, plateResult.numOf5)
        assertEquals(0, plateResult.numOf2_5)
    }
}