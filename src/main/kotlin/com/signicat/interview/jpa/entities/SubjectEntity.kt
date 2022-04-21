package com.signicat.interview.jpa.entities

import javax.persistence.*

@Table(name = "subject")
@Entity
class SubjectEntity(
    var username: String,
    var password: String,
    @ManyToMany @JoinTable(
        name = "subject_user_group",
        joinColumns = [JoinColumn(name = "subject_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "user_group_id", referencedColumnName = "id")]) var userGroups: MutableSet<UserGroupEntity>?,
    @Id @GeneratedValue var id: Long? = null)
{
    constructor(): this("", "", mutableSetOf(), null)
}