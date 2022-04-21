package com.signicat.interview.domain.services

import com.signicat.interview.domain.Subject

interface UserService {

    fun registerUser(user: Subject): Subject?
}