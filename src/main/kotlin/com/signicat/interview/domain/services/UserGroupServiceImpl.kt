package com.signicat.interview.domain.services

import com.signicat.interview.domain.UserGroup
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class UserGroupServiceImpl @Autowired constructor(val userRepositoryService: UserRepositoryService): UserGroupService {
    override fun createOrModifyUserGroup(userGroup: UserGroup): UserGroup {
        TODO("Not yet implemented")
    }

    override fun deleteUserGroup(userId: Long): Boolean {
        TODO("Not yet implemented")
    }

    override fun getUserGroupsForUserGroupKeys(userGroupKeys: List<String>?): Set<UserGroup> {
        if (userGroupKeys == null || userGroupKeys.isEmpty()) {
            return mutableSetOf()
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