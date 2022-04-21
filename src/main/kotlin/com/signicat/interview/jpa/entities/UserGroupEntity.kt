package com.signicat.interview.jpa.entities

import javax.persistence.*

@Table(name = "user_group")
@Entity
class UserGroupEntity(
    var name: String,
    @ManyToMany @JoinTable(
        name = "subject_user_group",
        joinColumns = [JoinColumn(name = "user_group_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "subject_id", referencedColumnName = "id")]) var users: MutableSet<SubjectEntity>,
    @Id @GeneratedValue var id: Long? = null) {
    constructor(): this("", mutableSetOf(), null)
}
