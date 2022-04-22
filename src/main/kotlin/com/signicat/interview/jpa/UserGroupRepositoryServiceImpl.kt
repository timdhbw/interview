package com.signicat.interview.jpa

import com.signicat.interview.domain.UserGroup
import com.signicat.interview.domain.services.interfaces.UserGroupRepositoryService
import com.signicat.interview.jpa.mapper.JpaMapper
import com.signicat.interview.jpa.repositories.UserGroupEntityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UserGroupRepositoryServiceImpl @Autowired constructor(
    val userGroupEntityRepository: UserGroupEntityRepository,
    val jpaMapper: JpaMapper
) : UserGroupRepositoryService {

    override fun deleteUserGroupById(userId: Int): Boolean {
        if (userGroupEntityRepository.existsById(userId.toLong())) {
            userGroupEntityRepository.deleteById(userId.toLong())
            return true
        }
        return false
    }

    override fun createOrUpdateUserGroup(userGroup: UserGroup): UserGroup {
        return jpaMapper.toDomain(userGroupEntityRepository
            .save(jpaMapper.toEntity(userGroup)!!))!!
    }

    override fun getUserGroupById(id: Int): UserGroup? {
        return jpaMapper.toDomain(
            userGroupEntityRepository
                .findById(id.toLong()).orElse(null)
        )
    }
}