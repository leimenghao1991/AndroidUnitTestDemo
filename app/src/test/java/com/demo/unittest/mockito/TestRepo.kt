package com.demo.unittest.mockito

class TestRepo {
    fun loadDbValue(uid: Long): User? {
        // query db
        return User(uid, "User$uid", 18)
    }
}