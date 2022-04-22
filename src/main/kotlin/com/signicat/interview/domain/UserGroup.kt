package com.signicat.interview.domain

class UserGroup (
    var id: Int?,
    var name: String,
    var defaultUser: Boolean
) {
    constructor(): this(null, "", true)
}
