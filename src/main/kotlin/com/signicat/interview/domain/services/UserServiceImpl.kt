package com.signicat.interview.domain.services

import com.signicat.interview.domain.User
import com.signicat.interview.domain.services.interfaces.UserRepositoryService
import com.signicat.interview.domain.services.interfaces.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl @Autowired constructor(val userRepositoryService: UserRepositoryService): UserService {

    override fun registerUser(user: User): User? {
        return userRepositoryService.save(user)
    }

    override fun login(username: String, password: String): String {
        TODO("Not yet implemented")
    }

}