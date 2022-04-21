package com.signicat.interview.api

import com.signicat.interview.domain.services.UserService
import com.signicat.interview.gen.api.UsersApiDelegate
import com.signicat.interview.gen.api.model.UserDto
import com.signicat.interview.jpa.mapper.JpaMapper
import com.signicat.interview.jpa.repositories.SubjectEntityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class ApiDelegatorImpl @Autowired constructor(val userService: UserService, val apiMapper: ApiMapper): UsersApiDelegate {

    override fun registerUser(userDto: UserDto): ResponseEntity<UserDto> {
        return super.registerUser(userDto)
    }
}