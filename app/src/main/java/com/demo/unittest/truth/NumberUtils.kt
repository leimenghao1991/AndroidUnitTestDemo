package com.demo.unittest.truth

object NumberUtils {
    /**
     * 将一个字符串装换成整数，如果不成功，那么返回默认值
     *
     * @param stringValue 需要转成整数的字符串
     * @param defaultValue 如果转型失败，返回该值
     * @return 返回转换后的值
     * */
    fun parseToInt(stringValue: String, defaultValue: Int): Int {
        return try {
            stringValue.toInt()
        } catch (e: Exception) {
            defaultValue
        }
    }
}