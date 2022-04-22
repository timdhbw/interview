package com.signicat.interview.api

import com.signicat.interview.domain.User
import com.signicat.interview.domain.UserGroup
import com.signicat.interview.domain.services.interfaces.UserGroupService
import com.signicat.interview.domain.services.interfaces.UserService
import com.signicat.interview.gen.api.UsergroupApiDelegate
import com.signicat.interview.gen.api.UsersApiDelegate
import com.signicat.interview.gen.api.model.UserDto
import com.signicat.interview.gen.api.model.UserGroupDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.context.request.NativeWebRequest
import java.util.*
import java.util.stream.Collectors

@Component
class ApiDelegatorImpl @Autowired constructor(
    val userService: UserService,
    val apiMapper: ApiMapper,
    val userGroupService: UserGroupService
) :
    UsersApiDelegate, UsergroupApiDelegate {

    override fun registerUser(userDto: UserDto): ResponseEntity<UserDto> {
        val user: User? = userService.registerUser(mapToDomain(userDto)!!)
        return ResponseEntity.ok(mapToDto(user))
    }

    override fun createUserGroup(userGroupDto: UserGroupDto): ResponseEntity<UserGroupDto> {
        return updateUserGroup(userGroupDto)
    }

    override fun updateUserGroup(userGroupDto: UserGroupDto): ResponseEntity<UserGroupDto> {
        val userGroup: UserGroup = apiMapper.toDomain(userGroupDto) ?: return ResponseEntity.badRequest().build()
        return ResponseEntity.ok(apiMapper.toDto(userGroupService
            .createOrUpdateUserGroup(userGroup)))
    }

    override fun getUserGroup(id: Int): ResponseEntity<UserGroupDto> {
        return ResponseEntity.ok(
            apiMapper.toDto(userGroupService.getUserGroupById(id))
        )
    }

    override fun deleteUsergroup(id: Int): ResponseEntity<Unit> {
        val deleted: Boolean = userGroupService.deleteUserGroup(id)
        if (deleted) {
            return ResponseEntity.ok().build()
        }
        return ResponseEntity.badRequest().build()
    }

    override fun getTest(): ResponseEntity<String> {
        return ResponseEntity.ok("Testresponse")
    }

    override fun getRequest(): Optional<NativeWebRequest> = Optional.empty()

    internal fun mapToDomain(userDto: UserDto?): User? {
        if (userDto == null) {
            return null
        }
        val user: User = apiMapper.toDomain(userDto)!!
        user.groups = userGroupService.getUserGroupsForUserGroupKeys(userDto.userGroupNames)
        return user
    }

    internal fun mapToDto(user: User?): UserDto? {
        if (user == null) {
            return null
        }
        val userDto: UserDto = apiMapper.toDto(user)!!
        userDto.userGroupNames = user.groups.stream().map(UserGroup::name).collect(Collectors.toList())
        return userDto
    }
}