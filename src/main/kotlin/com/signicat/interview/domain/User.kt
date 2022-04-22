package com.signicat.interview.domain

import java.util.stream.Collectors

data class User(
    var id: Int?,
    var username: String,
    var password: String,
    var groups: Set<UserGroup>
) {
    constructor() : this(null, "", "", mutableSetOf<UserGroup>())
}
