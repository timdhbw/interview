package com.signicat.interview.domain

data class Subject(
    val id: Int?,
    val username: String,
    val password: String,
    val groups: Set<UserGroup>
) {
    constructor() : this(null, "", "", setOf())

//    fun getUserGroupNames(): List<String> {
//        return groups.stream().map(UserGroup::name).collect(Collectors.toList())
//    }
}
