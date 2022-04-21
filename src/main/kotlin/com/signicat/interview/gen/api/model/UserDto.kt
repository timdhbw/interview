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

    @field:JsonProperty("userId") val userId: kotlin.Int? = null,

    @field:JsonProperty("username") val username: kotlin.String? = null,

    @field:JsonProperty("password") val password: kotlin.String? = null,

    @field:JsonProperty("userGroupNames") val userGroupNames: kotlin.collections.List<kotlin.String>? = null
) {

}

