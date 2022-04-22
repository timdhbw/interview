package com.signicat.interview.jpa.entities

import javax.persistence.*

@Table(name = "user_group")
@Entity
class UserGroupEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    var name: String,
    @ManyToMany @JoinTable(
        name = "subject_user_group",
        joinColumns = [JoinColumn(name = "user_group_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "subject_id", referencedColumnName = "id")]) var users: MutableSet<SubjectEntity>,
    var defaultUser: Boolean
    ) {
    constructor(): this(null, "", mutableSetOf(), true)
}
