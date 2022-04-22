package com.signicat.interview.jpa

import com.signicat.interview.domain.User
import com.signicat.interview.domain.UserGroup
import com.signicat.interview.domain.services.interfaces.UserRepositoryService
import com.signicat.interview.jpa.entities.SubjectEntity
import com.signicat.interview.jpa.mapper.JpaMapper
import com.signicat.interview.jpa.repositories.SubjectEntityRepository
import com.signicat.interview.jpa.repositories.UserGroupEntityRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class UserRepositoryServiceImpl @Autowired constructor(
    val rep: SubjectEntityRepository,
    val userGroupEntityRepository: UserGroupEntityRepository,
    val jpaMapper: JpaMapper): UserRepositoryService {

    override fun save(user: User?): User? {
        val entity: SubjectEntity = jpaMapper.toEntity(user) ?: return null
        val logger: Logger = LoggerFactory.getLogger(UserRepositoryServiceImpl::class.java.name)
        logger.info("(Repository)Register User: {}", entity)
        return jpaMapper.toDomain(rep.save(entity))
    }

    override fun get(id: Int?): User? {
        if (id == null) {
            return null
        }
        return jpaMapper
            .toDomain(rep
                .findById(id.toLong()).orElse(null))
    }

    override fun getAllUserGroups(): List<UserGroup?> {
        return userGroupEntityRepository.findAll()
            .map(jpaMapper::toDomain)
            .stream().collect(Collectors.toUnmodifiableList())
    }
}