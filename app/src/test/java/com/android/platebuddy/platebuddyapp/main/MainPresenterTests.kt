package com.android.platebuddy.platebuddyapp.main

import junit.framework.Assert.assertEquals
import org.junit.Test

class MainPresenterTests {

    @Test
    fun plateResultShouldAllBeZero() {
        val plateResult = MainPresenter().calculatePlateResult(45.0f, 45.0f)
        assertEquals(0, plateResult.numOf45)
        assertEquals(0, plateResult.numOf35)
        assertEquals(0, plateResult.numOf10)
        assertEquals(0, plateResult.numOf5)
        assertEquals(0, plateResult.numOf2_5)
    }

    @Test
    fun plateResultShouldBeOne45() {
        val plateResult = MainPresenter().calculatePlateResult(45.0f,135f)
        assertEquals(1, plateResult.numOf45)
        assertEquals(0, plateResult.numOf35)
        assertEquals(0, plateResult.numOf10)
        assertEquals(0, plateResult.numOf5)
        assertEquals(0, plateResult.numOf2_5)
    }

    @Test
    fun plateResultShouldBeOne35() {
        val plateResult = MainPresenter().calculatePlateResult(45.0f,115f)
        assertEquals(0, plateResult.numOf45)
        assertEquals(1, plateResult.numOf35)
        assertEquals(0, plateResult.numOf10)
        assertEquals(0, plateResult.numOf5)
        assertEquals(0, plateResult.numOf2_5)
    }

    @Test
    fun plateResultShouldBeOne10() {
        val plateResult = MainPresenter().calculatePlateResult(45.0f, 65f)
        assertEquals(0, plateResult.numOf45)
        assertEquals(0, plateResult.numOf35)
        assertEquals(1, plateResult.numOf10)
        assertEquals(0, plateResult.numOf5)
        assertEquals(0, plateResult.numOf2_5)
    }

    @Test
    fun plateResultShouldBeOne5() {
        val plateResult = MainPresenter().calculatePlateResult(45.0f, 55f)
        assertEquals(0, plateResult.numOf45)
        assertEquals(0, plateResult.numOf35)
        assertEquals(0, plateResult.numOf10)
        assertEquals(1, plateResult.numOf5)
        assertEquals(0, plateResult.numOf2_5)
    }

    @Test
    fun plateResultShouldBeOne2_5() {
        val plateResult = MainPresenter().calculatePlateResult(45.0f, 50f)
        assertEquals(0, plateResult.numOf45)
        assertEquals(0, plateResult.numOf35)
        assertEquals(0, plateResult.numOf10)
        assertEquals(0, plateResult.numOf5)
        assertEquals(1, plateResult.numOf2_5)
    }

    @Test
    fun plateResultShouldBeAMixOfEach() {
        val plateResult = MainPresenter().calculatePlateResult(45.0f, 240f)
        assertEquals(2, plateResult.numOf45)
        assertEquals(0, plateResult.numOf35)
        assertEquals(0, plateResult.numOf10)
        assertEquals(1, plateResult.numOf5)
        assertEquals(1, plateResult.numOf2_5)
    }

    @Test
    fun floatDivisibleCountShouldBe3() {
        val x = 30f
        val y = 10f
        assertEquals(3, x.divisibleCount(y))
    }
}