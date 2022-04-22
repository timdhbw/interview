package com.signicat.interview.gen.api.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param username 
 * @param password 
 */
data class InlineObjectDto(

    @field:JsonProperty("username") val username: kotlin.String? = null,

    @field:JsonProperty("password") val password: kotlin.String? = null
) {

}

