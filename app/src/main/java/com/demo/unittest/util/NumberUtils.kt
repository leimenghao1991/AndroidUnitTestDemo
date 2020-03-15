package com.demo.unittest.util

object NumberUtils {
    /**
     * 转换价格，将分为单位的价格转换为 xx.xx
     * */
    fun parsePrice(price: Int): String {
        var priceStr = price.toString()
        while ( priceStr.length <= 2) {
            priceStr = "0$priceStr"
        }
        val length = priceStr.length
        return """${priceStr.substring(0, length - 2)}.${priceStr.substring(length - 2)}"""
    }
}