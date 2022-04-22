package com.signicat.interview.repository

import com.signicat.interview.domain.User
import com.signicat.interview.domain.services.interfaces.UserRepositoryService
import com.signicat.interview.jpa.repositories.SubjectEntityRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class RepositoryTest(@Autowired val userRepository: UserRepositoryService, @Autowired val subjectEntityRepository: SubjectEntityRepository) {

    @Test
    internal fun testUserRepository() {
        val sub:User? = userRepository.save(User(1000, "Username", "123", HashSet()))
        val subSaved: User? = userRepository.get(sub?.id)
        if (sub != null) {
            assert(sub.equals(subSaved))
        }
        subjectEntityRepository.deleteById(sub?.id!!.toLong())
        assert(userRepository.get(sub?.id) == null)
    }
}