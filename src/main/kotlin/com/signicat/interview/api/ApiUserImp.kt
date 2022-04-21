package com.signicat.interview.api

import com.signicat.interview.gen.api.UsersApi
import com.signicat.interview.gen.api.UsersApiDelegate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
class ApiUserImp(@Autowired val apiDelegate: UsersApiDelegate): UsersApi {

    override fun getDelegate(): UsersApiDelegate {
        return apiDelegate
    }
}