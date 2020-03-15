package com.demo.unittest.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory: ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (ViewModel::class.java.isAssignableFrom(modelClass)) {
            return WatchDetailViewModel(WatchDetailActivityRepo()) as T
        }
        return super.create(modelClass)
    }
}