/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
*/
package com.signicat.interview.gen.api

import com.signicat.interview.gen.api.model.UserGroupDto
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Validated
@RequestMapping("\${api.base-path:/api}")
interface UsergroupApi {

    fun getDelegate(): UsergroupApiDelegate = object: UsergroupApiDelegate {}


    @RequestMapping(
            method = [RequestMethod.PUT],
            value = ["/usergroup"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun createUserGroup(@RequestBody userGroupDto: UserGroupDto
): ResponseEntity<UserGroupDto> {
        return getDelegate().createUserGroup(userGroupDto);
    }


    @RequestMapping(
            method = [RequestMethod.DELETE],
            value = ["/usergroup/{id}"]
    )
    fun deleteUsergroup( @PathVariable("id") id: kotlin.Int
): ResponseEntity<Unit> {
        return getDelegate().deleteUsergroup(id);
    }


    @RequestMapping(
            method = [RequestMethod.GET],
            value = ["/usergroup/{id}"],
            produces = ["application/json"]
    )
    fun getUserGroup( @PathVariable("id") id: kotlin.Int
): ResponseEntity<UserGroupDto> {
        return getDelegate().getUserGroup(id);
    }


    @RequestMapping(
            method = [RequestMethod.POST],
            value = ["/usergroup"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun updateUserGroup(@RequestBody userGroupDto: UserGroupDto
): ResponseEntity<UserGroupDto> {
        return getDelegate().updateUserGroup(userGroupDto);
    }
}
