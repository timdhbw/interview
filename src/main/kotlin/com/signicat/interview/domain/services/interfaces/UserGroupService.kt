package com.signicat.interview.domain.services.interfaces

import com.signicat.interview.domain.UserGroup

interface UserGroupService {

    fun createOrUpdateUserGroup(userGroup: UserGroup): UserGroup

    fun deleteUserGroup(userId: Int): Boolean

    fun getUserGroupById(id: Int): UserGroup?

    fun getUserGroupsForUserGroupKeys(userGroupKeys: List<String>?): Set<UserGroup>

}