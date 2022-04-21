package com.signicat.interview.jpa

import com.signicat.interview.domain.Subject
import com.signicat.interview.domain.services.UserRepositoryService
import com.signicat.interview.jpa.entities.SubjectEntity
import com.signicat.interview.jpa.mapper.JpaMapper
import com.signicat.interview.jpa.repositories.SubjectEntityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UserRepositoryServiceImpl @Autowired constructor(val rep: SubjectEntityRepository, val jpaMapper: JpaMapper): UserRepositoryService {

    override fun save(subject: Subject?): Subject? {
        val entity: SubjectEntity = jpaMapper.toEntity(subject) ?: return null
        return jpaMapper.toDomain(rep.save(entity))
    }

    override fun get(id: Int?): Subject? {
        if (id == null) {
            return null
        }
        return jpaMapper.toDomain(rep.findById(id.toLong()).orElse(null))
    }
}