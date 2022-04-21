package com.signicat.interview.jpa.repositories

import com.signicat.interview.jpa.entities.SubjectEntity
import org.springframework.data.repository.CrudRepository

interface SubjectEntityRepository: CrudRepository<SubjectEntity, Long> {
}