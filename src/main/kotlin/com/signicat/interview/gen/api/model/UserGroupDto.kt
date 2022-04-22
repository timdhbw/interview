package com.signicat.interview.gen.api.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param id 
 * @param name 
 * @param defaultUser 
 */
data class UserGroupDto(

    @field:JsonProperty("id") var id: kotlin.Int? = null,

    @field:JsonProperty("name") var name: kotlin.String? = null,

    @field:JsonProperty("defaultUser") var defaultUser: kotlin.Boolean? = null
) {

}

