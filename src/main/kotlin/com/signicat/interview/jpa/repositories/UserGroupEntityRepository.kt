package com.signicat.interview.jpa.repositories

import com.signicat.interview.jpa.entities.UserGroupEntity
import org.springframework.data.repository.CrudRepository

interface UserGroupEntityRepository: CrudRepository<UserGroupEntity, Long> {
}