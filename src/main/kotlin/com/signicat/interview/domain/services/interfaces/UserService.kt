package com.signicat.interview.domain.services.interfaces

import com.signicat.interview.domain.User

interface UserService {

    fun registerUser(user: User): User?

    fun login(username: String, password: String): String

}