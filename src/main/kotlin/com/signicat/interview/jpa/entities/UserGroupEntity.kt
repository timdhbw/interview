package com.signicat.interview.jpa.entities

import javax.persistence.*

@Table(name = "user_group")
@Entity
class UserGroupEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    var name: String,
    var defaultUser: Boolean
    ) {
    constructor(): this(null, "",  true)
}
