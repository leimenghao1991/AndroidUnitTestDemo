package com.demo.unittest.truth

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class OtherApis {
    @Test
    fun test1() {
        val str = "my name is xxx"
        assertThat(str).startsWith("my")
    }

    @Test
    fun test2() {
        val list = mutableListOf("zhangsan", "lisi", "wangwu")
        assertThat(list).containsExactly("zhangsan", "lisi", "wangwu")
        assertThat(list).contains("zhangsan")
        assertThat(list).doesNotContain("hello")
        assertThat(list).containsAnyIn(listOf("zhangsan", "hello"))
    }
}