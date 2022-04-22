/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
*/
package com.signicat.interview.gen.api

import com.signicat.interview.gen.api.model.InlineObjectDto
import com.signicat.interview.gen.api.model.UserDto
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Validated
@RequestMapping("\${api.base-path:/api}")
interface UsersApi {

    fun getDelegate(): UsersApiDelegate = object: UsersApiDelegate {}


    @RequestMapping(
            method = [RequestMethod.GET],
            value = ["/users/test"],
            produces = ["application/json"]
    )
    fun getTest(): ResponseEntity<kotlin.String> {
        return getDelegate().getTest();
    }


    @RequestMapping(
            method = [RequestMethod.POST],
            value = ["/users/login"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun login( @RequestBody inlineObjectDto: InlineObjectDto
): ResponseEntity<kotlin.String> {
        return getDelegate().login(inlineObjectDto);
    }


    @RequestMapping(
            method = [RequestMethod.POST],
            value = ["/users/register"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun registerUser( @RequestBody userDto: UserDto
): ResponseEntity<UserDto> {
        return getDelegate().registerUser(userDto);
    }
}
