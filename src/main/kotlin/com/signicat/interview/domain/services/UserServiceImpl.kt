package com.signicat.interview.domain.services

import com.signicat.interview.domain.User
import com.signicat.interview.domain.services.interfaces.EncryptService
import com.signicat.interview.domain.services.interfaces.UserRepositoryService
import com.signicat.interview.domain.services.interfaces.UserService
import com.signicat.interview.security.TokenFactoryWrapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.nio.charset.StandardCharsets
import java.security.MessageDigest

@Service
class UserServiceImpl @Autowired constructor(
    val userRepositoryService: UserRepositoryService,
    val tokenFactoryWrapper: TokenFactoryWrapper,
    val encryptService: EncryptService
) : UserService {

    override fun registerUser(user: User): User? {
        user.password = passwordEncryption(user.password)
        return userRepositoryService.save(user)
    }

    override fun login(username: String, password: String): String {
        val user: User = userRepositoryService.getUserByUsername(username)!!
        val bol = user.password == passwordEncryption(password)
        if (!bol) {
            throw RuntimeException("Wrong password!")
        }
        return tokenFactoryWrapper.tokenFactory.generateWithUser(user)
    }

    private fun passwordEncryption(password: String): String {
        return encryptService.sha256(password)
    }
}