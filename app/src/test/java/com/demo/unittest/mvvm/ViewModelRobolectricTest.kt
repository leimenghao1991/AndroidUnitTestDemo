package com.demo.unittest.mvvm

import com.demo.unittest.getValue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ViewModelRobolectricTest {
    private lateinit var model: WatchDetailViewModel
    private lateinit var repo: WatchDetailActivityRepo

    @Before
    fun init() {
        repo = WatchDetailActivityRepo()
        model = WatchDetailViewModel(repo)
    }

    @Test
    fun example() {
        model.loadWatchInfo()
        val result = getValue(model.priceLiveData)
        println("result = $result")
    }
}