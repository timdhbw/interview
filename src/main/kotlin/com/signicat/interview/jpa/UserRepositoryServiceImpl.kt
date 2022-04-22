package com.signicat.interview.jpa

import com.signicat.interview.domain.User
import com.signicat.interview.domain.services.interfaces.UserRepositoryService
import com.signicat.interview.jpa.entities.SubjectEntity
import com.signicat.interview.jpa.mapper.JpaMapper
import com.signicat.interview.jpa.repositories.SubjectEntityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UserRepositoryServiceImpl @Autowired constructor(
    val subjectEntityRepository: SubjectEntityRepository,
    val jpaMapper: JpaMapper): UserRepositoryService {

    override fun save(user: User?): User? {
        val entity: SubjectEntity = jpaMapper.toEntity(user) ?: return null
        return jpaMapper.toDomain(subjectEntityRepository.save(entity))
    }

    override fun get(id: Int?): User? {
        if (id == null) {
            return null
        }
        return jpaMapper
            .toDomain(subjectEntityRepository
                .findById(id.toLong()).orElse(null))
    }

    override fun getUserByUsername(username: String): User? {
        return jpaMapper.toDomain(subjectEntityRepository.findByUsername(username))
    }
}