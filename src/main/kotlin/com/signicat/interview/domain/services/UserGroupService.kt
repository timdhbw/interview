package com.signicat.interview.domain.services

import com.signicat.interview.domain.UserGroup

interface UserGroupService {

    fun createOrModifyUserGroup(userGroup: UserGroup): UserGroup

    fun deleteUserGroup(userId: Long): Boolean

    fun getUserGroupsForUserGroupKeys(userGroupKeys: List<String>?): Set<UserGroup>

}