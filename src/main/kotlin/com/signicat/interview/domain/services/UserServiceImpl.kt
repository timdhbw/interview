package com.signicat.interview.domain.services

import com.signicat.interview.domain.Subject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl @Autowired constructor(val userRepositoryService: UserRepositoryService): UserService {

    override fun registerUser(user: Subject): Subject? {
        return userRepositoryService.save(user)
    }

}