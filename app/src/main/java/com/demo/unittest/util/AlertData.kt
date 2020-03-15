package com.demo.unittest.util

data class AlertData<T>(
    val code: Int? = null,
    val msg: String? = null,
    val obj: T? = null
)