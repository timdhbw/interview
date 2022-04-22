package com.signicat.interview.config

import org.springframework.security.core.GrantedAuthority

class JWTAuthority(val authorty: String): GrantedAuthority {

    override fun getAuthority(): String {
        return authorty
    }

}