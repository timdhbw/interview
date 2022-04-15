package com.signicat.interview.security

import com.nimbusds.jose.JOSEObjectType.JWT
import com.nimbusds.jose.JWSAlgorithm.ES256
import com.nimbusds.jose.JWSHeader
import com.nimbusds.jose.crypto.ECDSASigner
import com.nimbusds.jose.jwk.ECKey
import com.nimbusds.jwt.JWTClaimsSet
import com.nimbusds.jwt.SignedJWT
import java.time.Instant.now
import java.util.Date.from

const val TOKEN_EXPIRATION_TIME = 600L

class TokenFactory(
    private val key: ECKey
) {
    fun generate(): String =
        SignedJWT(
            createHeader(),
            createClaimsSet()
        ).run {
            sign(ECDSASigner(key.toECPrivateKey()))
            serialize()
        }

    private fun createHeader() =
        JWSHeader.Builder(ES256)
            .type(JWT)
            .keyID(key.keyID)
            .build();

    private fun createClaimsSet() =
        JWTClaimsSet.Builder()
            .claim("key", "value")
            .expirationTime(
                from(
                    now().plusSeconds(TOKEN_EXPIRATION_TIME)
                )
            ).build()
}
