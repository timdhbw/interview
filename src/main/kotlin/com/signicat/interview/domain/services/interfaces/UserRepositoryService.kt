package com.signicat.interview.domain.services.interfaces

import com.signicat.interview.domain.User
import com.signicat.interview.domain.UserGroup

interface UserRepositoryService {

    fun save(user: User?): User?

    fun get(id: Int?): User?

    fun getAllUserGroups(): List<UserGroup?>

    fun getUserByUsername(username: String): User?
}