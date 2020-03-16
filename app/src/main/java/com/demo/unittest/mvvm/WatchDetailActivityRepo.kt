package com.demo.unittest.mvvm

import android.os.Handler
import android.os.HandlerThread
import androidx.annotation.WorkerThread
import kotlin.random.Random

class WatchDetailActivityRepo {
    companion object {
        const val MIN_PRICE = 50000
        const val MAX_PRICE = 100000
    }

    private val mThread = HandlerThread("Repo")
    private val mHandler: Handler

    init {
        mThread.start()
        mHandler = Handler(mThread.looper)
    }

    fun loadWatchInfo(callback: ICallback<Int>) {
        val randomDelay = Random.nextInt(2)
        mHandler.postDelayed({
            callback.onResult(Random.nextInt(MIN_PRICE, MAX_PRICE))
        }, randomDelay * 1000L)
    }

    fun buyWatch(callback: ICallback<Boolean>) {
        val randomDelay = Random.nextInt(5)
        mHandler.postDelayed({
            callback.onResult(true)
        }, randomDelay * 1000L)
    }
}

interface ICallback<D> {
    @WorkerThread
    fun onResult(result: D)
}