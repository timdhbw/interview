package com.signicat.interview.domain.services.interfaces

import com.signicat.interview.domain.UserGroup

interface UserGroupRepositoryService {
    fun deleteUserGroupById(userId: Int): Boolean
    fun createOrUpdateUserGroup(userGroup: UserGroup): UserGroup
    fun getUserGroupById(id: Int): UserGroup?
    fun getAllUserGroups(): List<UserGroup?>
}
