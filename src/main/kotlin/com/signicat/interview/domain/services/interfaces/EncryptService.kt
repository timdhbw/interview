package com.signicat.interview.domain.services.interfaces

interface EncryptService {
    fun sha256(toEncrypt: String): String
}