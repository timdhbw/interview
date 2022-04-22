package com.signicat.interview.domain.services.interfaces

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.security.MessageDigest

@Service
class EncryptServiceImpl (
    @Value("\${encrypt.salt}")
    private val salt: String
        ): EncryptService {

    override fun sha256(toEncrypt :String): String {
        return hashString(toEncrypt + salt, algorithm = "SHA-256")
    }

    private fun hashString(input: String, algorithm: String): String {
        return MessageDigest
            .getInstance(algorithm)
            .digest(input.toByteArray())
            .fold("") { str, it -> str + "%02x".format(it) }
    }
}