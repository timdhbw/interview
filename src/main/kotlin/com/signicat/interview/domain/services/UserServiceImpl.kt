package com.signicat.interview.domain.services

import com.signicat.interview.domain.Subject
import com.signicat.interview.domain.UserGroup
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl @Autowired constructor(val userRepositoryService: UserRepositoryService): UserService {

    override fun registerUser(user: Subject): Subject? {
        val logger: Logger = LoggerFactory.getLogger(UserServiceImpl::class.java.name)
        if (user.groups.isEmpty()) {
            addDefaultUserGroup(user)
        }
        logger.info("(Service)Register User: {}", user)
        return userRepositoryService.save(user)
    }

    internal fun addDefaultUserGroup(newUser: Subject) {
        val defUserGroup: UserGroup? = userRepositoryService
            .getAllUserGroups()
            .firstOrNull { userGroup -> 1 == userGroup?.id }
        if (defUserGroup != null) {
            newUser.groups = setOf(defUserGroup)
        }
    }
}