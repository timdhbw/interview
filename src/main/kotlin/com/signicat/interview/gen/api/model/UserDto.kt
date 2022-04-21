package com.signicat.interview.gen.api.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param userId 
 * @param username 
 * @param password 
 * @param userGroupNames 
 */
data class UserDto(

    @field:JsonProperty("userId") var id: kotlin.Int? = null,

    @field:JsonProperty("username") var username: kotlin.String? = null,

    @field:JsonProperty("password") var password: kotlin.String? = null,

    @field:JsonProperty("userGroupNames") var userGroupNames: kotlin.collections.List<kotlin.String>? = null
) {

}

