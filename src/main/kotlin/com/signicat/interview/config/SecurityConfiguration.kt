package com.signicat.interview.config

import com.signicat.interview.security.TokenFactoryWrapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@EnableWebSecurity
class SecurityConfiguration @Autowired constructor(val tokenFactoryWrapper: TokenFactoryWrapper) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
//        super.configure(http)
        http?.cors()?.and()?.csrf()?.disable()
            ?.authorizeRequests()
            ?.antMatchers("/api/users/test")?.permitAll()
            ?.antMatchers("/api/users/login")?.permitAll()
            ?.antMatchers("/api/users/register")?.permitAll()
            ?.anyRequest()?.authenticated()

        http?.apply(JWTTokenFilterConfigurer(tokenFactoryWrapper.tokenFactory))
    }

}