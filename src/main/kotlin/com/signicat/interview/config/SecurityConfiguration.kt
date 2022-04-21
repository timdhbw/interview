package com.signicat.interview.config

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@EnableWebSecurity
class SecurityConfiguration : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
//        super.configure(http)
        http?.cors()?.and()?.csrf()?.disable()
        http?.authorizeRequests()?.antMatchers("/api/users/test")?.permitAll()?.antMatchers("/api/users/register")?.permitAll()
    }
}