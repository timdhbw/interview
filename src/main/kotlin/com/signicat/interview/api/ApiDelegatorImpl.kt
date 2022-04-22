package com.signicat.interview.api

import com.signicat.interview.domain.Subject
import com.signicat.interview.domain.UserGroup
import com.signicat.interview.domain.services.UserGroupService
import com.signicat.interview.domain.services.UserService
import com.signicat.interview.gen.api.UsersApiDelegate
import com.signicat.interview.gen.api.model.UserDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class ApiDelegatorImpl @Autowired constructor(
    val userService: UserService,
    val apiMapper: ApiMapper,
    val userGroupService: UserGroupService
) :
    UsersApiDelegate {

    override fun registerUser(userDto: UserDto): ResponseEntity<UserDto> {
        val logger: Logger = LoggerFactory.getLogger(ApiDelegatorImpl::class.java.name)
        logger.info("Register User: {}", userDto)
        val subject: Subject? = userService.registerUser(mapToDomain(userDto)!!)
        return ResponseEntity.ok(mapToDto(subject))
    }

    override fun getTest(): ResponseEntity<String> {
        return ResponseEntity.ok("Testresponse")
    }

    internal fun mapToDomain(userDto: UserDto?): Subject? {
        if (userDto == null) {
            return null
        }
        val subject: Subject = apiMapper.toDomain(userDto)!!
        subject.groups = userGroupService.getUserGroupsForUserGroupKeys(userDto.userGroupNames)
        return subject
    }

    internal fun mapToDto(subject: Subject?): UserDto? {
        if (subject == null) {
            return null
        }
        val userDto: UserDto = apiMapper.toDto(subject)!!
        userDto.userGroupNames = subject.groups.stream().map(UserGroup::name).collect(Collectors.toList())
        return userDto
    }
}