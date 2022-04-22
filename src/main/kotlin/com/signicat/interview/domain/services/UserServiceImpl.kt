package com.signicat.interview.domain.services

import com.nimbusds.jose.jwk.Curve
import com.nimbusds.jose.jwk.gen.ECKeyGenerator
import com.signicat.interview.domain.User
import com.signicat.interview.domain.services.interfaces.UserRepositoryService
import com.signicat.interview.domain.services.interfaces.UserService
import com.signicat.interview.security.TokenFactory
import com.signicat.interview.security.TokenFactoryWrapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl @Autowired constructor(
    val userRepositoryService: UserRepositoryService,
    val tokenFactoryWrapper: TokenFactoryWrapper
) : UserService {

    override fun registerUser(user: User): User? {
        return userRepositoryService.save(user)
    }

    override fun login(username: String, password: String): String {
        val user: User = userRepositoryService.getUserByUsername(username)!!
        val bol = user.password == password
        if (!bol) {
            throw RuntimeException("Wrong password!")
        }
        return tokenFactoryWrapper.tokenFactory.generateWithUser(user)
    }

}