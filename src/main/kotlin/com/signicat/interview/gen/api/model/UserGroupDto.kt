package com.signicat.interview.gen.api.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param userGroupId 
 * @param userGroupName 
 */
data class UserGroupDto(

    @field:JsonProperty("userGroupId") var id: kotlin.Int? = null,

    @field:JsonProperty("userGroupName") var name: kotlin.String? = null
) {

}

