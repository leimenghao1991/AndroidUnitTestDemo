package com.demo.unittest.mvvm

import org.junit.Assert
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

class WatchDetailViewModelTest {
    companion object {
        const val MIN_PRICE = 50000
        const val MAX_PRICE = 100000

        const val LESS_THAN_MIN = 49999
        const val MORE_THAN_MAX = 100001
    }
    private lateinit var model: WatchDetailViewModel

    @Before
    fun init() {
        model = WatchDetailViewModel(null)
    }

    @Test
    fun test_checkPrice_Min() {
        val result = model.checkPrice(MIN_PRICE)
        Assert.assertTrue(result)
    }

    @Test
    fun test_checkPrice_Max() {
        val result = model.checkPrice(MAX_PRICE)
        Assert.assertTrue(result)
    }

    @Test
    fun test_checkPrice_lessThanMin() {
        val result = model.checkPrice(LESS_THAN_MIN)
        Assert.assertFalse(result)
    }

    @Ignore
    @Test
    fun test_checkPrice_moreThanMax() {
        val result = model.checkPrice(MORE_THAN_MAX)
        Assert.assertFalse(result)
        System.out.println("lemon")
    }


}