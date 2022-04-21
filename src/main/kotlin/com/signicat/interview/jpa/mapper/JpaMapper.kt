package com.signicat.interview.jpa.mapper

import com.signicat.interview.domain.Subject
import com.signicat.interview.domain.UserGroup
import com.signicat.interview.jpa.entities.SubjectEntity
import com.signicat.interview.jpa.entities.UserGroupEntity
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface JpaMapper {

    @Mapping(target = "groups", source = "userGroups")
    fun toDomain(user: SubjectEntity?): Subject?

    fun toDomain(userGroupEntity: UserGroupEntity?): UserGroup?

    @InheritInverseConfiguration
    fun toEntity(subject: Subject?): SubjectEntity?

    @InheritInverseConfiguration
    @Mapping(target = "users", ignore = true)
    fun toEntity(userGroup: UserGroup?): UserGroupEntity?
}