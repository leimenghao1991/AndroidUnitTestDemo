package com.demo.unittest.truth

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class NumberUtilsTest {
    @Test
    fun test_parseToInt_negative() {
        // 测试负数转换
        val result = NumberUtils.parseToInt("-2", -1)
        assertThat(result).isEqualTo(-2)
    }

    @Test
    fun test_parseToInt_negativeFloat() {
        // 测试负小数
        val result = NumberUtils.parseToInt("-2.1", -1)
        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun test_parseToInt_zero() {
        // 测试0
        val result = NumberUtils.parseToInt("0", -1)
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun test_parseToInt_positive() {
        val result = NumberUtils.parseToInt("1", -1)
        assertThat(result).isEqualTo(1)
    }
    
    @Test
    fun test_parseToInt_positiveFloat() {
        val result = NumberUtils.parseToInt("1.1", -1)
        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun test_parseToInt_string() {
        val result = NumberUtils.parseToInt("string", -1)
        assertThat(result).isEqualTo(-1)
    }
}