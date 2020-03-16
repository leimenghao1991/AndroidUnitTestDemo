package com.demo.unittest.mockito

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TestPresenterTest {
    private val repo = mock<TestRepo>()
    private lateinit var presenter: TestPresenter

    @Before
    fun init() {
        given(repo.loadDbValue(any())).willReturn(User(100L, "MockUser", 15))
        presenter = TestPresenter(repo)
    }

    @Test
    fun addFriend() {
        presenter.addFriend(100)
        Assert.assertTrue(presenter.friends.any { it.uid == 100L })
    }
}