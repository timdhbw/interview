package com.signicat.interview.api

import com.signicat.interview.gen.api.UsergroupApi
import com.signicat.interview.gen.api.UsergroupApiDelegate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
class ApiUserGroupImpl(@Autowired val apiDelegate: UsergroupApiDelegate): UsergroupApi {

    override fun getDelegate(): UsergroupApiDelegate {
        return apiDelegate
    }
}