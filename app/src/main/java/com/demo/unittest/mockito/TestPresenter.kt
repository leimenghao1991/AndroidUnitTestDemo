package com.demo.unittest.mockito

class TestPresenter(private val repo: TestRepo) {
    val friends = mutableListOf<User>()

    /**
     * 添加好友
     * */
    fun addFriend(uid: Long) {
        val user = repo.loadDbValue(uid)
        user ?: return
        friends.add(user)
    }
}