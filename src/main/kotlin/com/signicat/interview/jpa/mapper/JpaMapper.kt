package com.signicat.interview.jpa.mapper

import com.signicat.interview.domain.User
import com.signicat.interview.domain.UserGroup
import com.signicat.interview.jpa.entities.SubjectEntity
import com.signicat.interview.jpa.entities.UserGroupEntity
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface JpaMapper {

    @Mapping(target = "groups", source = "userGroups")
    fun toDomain(user: SubjectEntity?): User?

    fun toDomain(userGroupEntity: UserGroupEntity?): UserGroup?

    @InheritInverseConfiguration
    fun toEntity(user: User?): SubjectEntity?

    @InheritInverseConfiguration
    fun toEntity(userGroup: UserGroup?): UserGroupEntity?
}