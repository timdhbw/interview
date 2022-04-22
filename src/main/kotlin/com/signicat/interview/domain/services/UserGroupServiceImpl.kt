package com.signicat.interview.domain.services

import com.signicat.interview.domain.UserGroup
import com.signicat.interview.domain.services.interfaces.UserGroupRepositoryService
import com.signicat.interview.domain.services.interfaces.UserGroupService
import com.signicat.interview.domain.services.interfaces.UserRepositoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class UserGroupServiceImpl @Autowired constructor(
    val userRepositoryService: UserRepositoryService,
    val userGroupRepositoryService: UserGroupRepositoryService
    ): UserGroupService {
    override fun createOrUpdateUserGroup(userGroup: UserGroup): UserGroup {
        return userGroupRepositoryService.createOrUpdateUserGroup(userGroup)
    }

    override fun deleteUserGroup(userId: Int): Boolean {
        return userGroupRepositoryService.deleteUserGroupById(userId)
    }

    override fun getUserGroupById(id: Int): UserGroup? {
        return userGroupRepositoryService.getUserGroupById(id)
    }

    override fun getUserGroupsForUserGroupKeys(userGroupKeys: List<String>?): Set<UserGroup> {
        if (userGroupKeys == null || userGroupKeys.isEmpty()) {
            return getDefaultUserGroups()
        }
        val uGs: MutableSet<UserGroup> = userGroupKeys.stream()
            .map(this::getUserGroupByKey)
            .filter(Objects::nonNull)
            .collect(Collectors.toSet())
        if (uGs.isEmpty()) {
            return getDefaultUserGroups()
        }
        return uGs
    }

    internal fun getUserGroupByKey(key: String): UserGroup? {
        return userRepositoryService.getAllUserGroups()
            .filterNotNull().firstOrNull { ug -> key.lowercase() == ug.name.lowercase() }
    }

    internal fun getDefaultUserGroups(): MutableSet<UserGroup> {
        return userRepositoryService
            .getAllUserGroups()
            .filterNotNull()
            .filter(UserGroup::defaultUser)
            .stream().collect(Collectors.toSet())
    }
}