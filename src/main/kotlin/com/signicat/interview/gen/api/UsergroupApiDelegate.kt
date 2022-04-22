package com.signicat.interview.gen.api

import com.signicat.interview.gen.api.model.UserGroupDto
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.context.request.NativeWebRequest
import java.util.*

/**
 * A delegate to be called by the {@link UsergroupApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = ["org.openapitools.codegen.languages.KotlinSpringServerCodegen"])
interface UsergroupApiDelegate {

    fun getRequest(): Optional<NativeWebRequest> = Optional.empty()

    /**
     * @see UsergroupApi#createUserGroup
     */
    fun createUserGroup(userGroupDto: UserGroupDto): ResponseEntity<UserGroupDto> {
        getRequest().ifPresent { request ->
            for (mediaType in MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"userGroupId\" : 0,  \"userGroupName\" : \"userGroupName\"}")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }


    /**
     * @see UsergroupApi#deleteUsergroup
     */
    fun deleteUsergroup(id: kotlin.Int): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }


    /**
     * @see UsergroupApi#getUserGroup
     */
    fun getUserGroup(id: kotlin.Int): ResponseEntity<UserGroupDto> {
        getRequest().ifPresent { request ->
            for (mediaType in MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"userGroupId\" : 0,  \"userGroupName\" : \"userGroupName\"}")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }


    /**
     * @see UsergroupApi#updateUserGroup
     */
    fun updateUserGroup(userGroupDto: UserGroupDto): ResponseEntity<UserGroupDto> {
        getRequest().ifPresent { request ->
            for (mediaType in MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"userGroupId\" : 0,  \"userGroupName\" : \"userGroupName\"}")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }

}
