package com.signicat.interview.api

import com.signicat.interview.domain.Subject
import com.signicat.interview.gen.api.model.UserDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface ApiMapper {

    @Mapping(target = "userGroupNames", ignore = true)
    fun toDto(user: Subject?): UserDto?

    @Mapping(target = "groups", ignore = true)
    fun toDomain(user: UserDto?): Subject?
}