package com.signicat.interview.domain.services

import com.signicat.interview.domain.Subject
import com.signicat.interview.domain.UserGroup

interface UserRepositoryService {

    fun save(subject: Subject?): Subject?

    fun get(id: Int?): Subject?

    fun getAllUserGroups(): List<UserGroup?>
}