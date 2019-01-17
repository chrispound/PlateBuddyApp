package com.android.platebuddy.platebuddyapp.main

import junit.framework.Assert.assertEquals
import org.junit.Test

class MainPresenterTests {

    @Test
    fun plateResultShouldAllBeZero() {
        val plateResult = MainPresenter().calculatePlateResult(45.0f, 45.0f).plates
        for (plate in plateResult) {
            assertEquals(0, plate.count)
        }
    }

    @Test
    fun plateResultShouldBeOne45() {
        val plateResult = MainPresenter().calculatePlateResult(45.0f, 135f).plates
        for (plate in plateResult) {
            if (plate.weight == 45.0f) {
                assertEquals(1, plate.count)
            } else {
                assertEquals(0, plate.count)
            }
        }
    }

    @Test
    fun plateResultShouldBeOne35() {
        val plateResult = MainPresenter().calculatePlateResult(45.0f, 115f).plates
        for (plate in plateResult) {
            if (plate.weight == 35.0f) {
                assertEquals(1, plate.count)
            } else {
                assertEquals(0, plate.count)
            }
        }
    }

    @Test
    fun plateResultShouldBeOne25(){
        val plateResult = MainPresenter().calculatePlateResult(45.0f, 95f).plates
        for (plate in plateResult) {
            if (plate.weight == 25.0f) {
                assertEquals(1, plate.count)
            } else {
                assertEquals(0, plate.count)
            }
        }
    }

    @Test
    fun plateResultShouldBeOne10() {
        val plateResult = MainPresenter().calculatePlateResult(45.0f, 65f).plates
        for (plate in plateResult) {
            if (plate.weight == 10.0f) {
                assertEquals(1, plate.count)
            } else {
                assertEquals(0, plate.count)
            }
        }
    }

    @Test
    fun plateResultShouldBeOne5() {
        val plateResult = MainPresenter().calculatePlateResult(45.0f, 55f).plates
        for (plate in plateResult) {
            if (plate.weight == 5.0f) {
                assertEquals(1, plate.count)
            } else {
                assertEquals(0, plate.count)
            }
        }
    }

    @Test
    fun plateResultShouldBeOne2_5() {
        val plateResult = MainPresenter().calculatePlateResult(45.0f, 50f).plates
        for (plate in plateResult) {
            if (plate.weight == 2.5f) {
                assertEquals(1, plate.count)
            } else {
                assertEquals(0, plate.count)
            }
        }
    }

    @Test
    fun plateResultShouldBeAMixOfEach() {
        val plateResult = MainPresenter().calculatePlateResult(45.0f, 240f).plates
        for (plate in plateResult) {
            when(plate.weight) {
                45.0f -> assertEquals(2, plate.count)
                35.0f -> assertEquals(0, plate.count)
                25.0f -> assertEquals(0, plate.count)
                10.0f -> assertEquals(0, plate.count)
                5.0f -> assertEquals(1, plate.count)
                2.5f -> assertEquals(1, plate.count)
            }
        }
    }

    @Test
    fun floatDivisibleCountShouldBe3() {
        val x = 30f
        val y = 10f
        assertEquals(3, x.divisibleCount(y))
    }
}