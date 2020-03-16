package com.demo.unittest.mvvm

import com.demo.unittest.getValue
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ViewModelWithMockTest {
    private lateinit var viewModel: WatchDetailViewModel

    @Before
    fun setUp() {
        val mockedRepo = mock<WatchDetailActivityRepo>()
        whenever(mockedRepo.loadWatchInfo(any())).then { it ->
            val callback = it.arguments[0] as ICallback<Int>
            callback.onResult(50000)
        }

        viewModel = WatchDetailViewModel(mockedRepo)
    }

    @Test
    fun test_loadWatchInfo() {
        viewModel.loadWatchInfo()
        val value = getValue(viewModel.priceLiveData)
        Assert.assertEquals("price:￥500.00", value)
    }
}