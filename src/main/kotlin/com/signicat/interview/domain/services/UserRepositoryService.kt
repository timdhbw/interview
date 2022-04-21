package com.signicat.interview.domain.services

import com.signicat.interview.domain.Subject

interface UserRepositoryService {

    fun save(subject: Subject?): Subject?

    fun get(id: Int?): Subject?
}