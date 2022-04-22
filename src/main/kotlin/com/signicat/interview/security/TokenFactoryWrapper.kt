package com.signicat.interview.security

import com.nimbusds.jose.jwk.Curve
import com.nimbusds.jose.jwk.gen.ECKeyGenerator
import org.springframework.stereotype.Component

@Component
class TokenFactoryWrapper() {

    final val tokenFactory: TokenFactory

    init {
        val key = ECKeyGenerator(Curve.P_256)
            .keyID("0")
            .generate()
        tokenFactory = TokenFactory(key)
    }
}