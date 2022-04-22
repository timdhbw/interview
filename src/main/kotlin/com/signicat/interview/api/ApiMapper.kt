package com.signicat.interview.api

import com.signicat.interview.domain.User
import com.signicat.interview.domain.UserGroup
import com.signicat.interview.gen.api.model.UserDto
import com.signicat.interview.gen.api.model.UserGroupDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface ApiMapper {

    @Mapping(target = "userGroupNames", ignore = true)
    fun toDto(user: User?): UserDto?

    fun toDto(userGroup: UserGroup?): UserGroupDto?

    @Mapping(target = "groups", ignore = true)
    fun toDomain(user: UserDto?): User?

    fun toDomain(userGroupDto: UserGroupDto?): UserGroup?

}