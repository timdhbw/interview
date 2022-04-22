package com.signicat.interview.config

import com.nimbusds.jose.crypto.ECDSAVerifier
import com.nimbusds.jwt.SignedJWT
import com.signicat.interview.security.TokenFactory
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class JWTTokenFilter(val tokenFactory: TokenFactory): OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token: String? = resolveToken(request)
        try {
            if (token != null && validateToken(token)) {
                val auth: Authentication = getAuthentication(token)
                SecurityContextHolder.getContext().authentication = auth
            }
        } catch (ex: Exception) {
            SecurityContextHolder.clearContext()
            response.sendError(500, ex.message)
            return
        }
        filterChain.doFilter(request, response)
    }

    private fun resolveToken(req: HttpServletRequest?): String? {
        val bearerToken = req?.getHeader("Authorization")
        return if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            bearerToken.substring(7)
        } else null
    }

    private fun validateToken(token: String): Boolean {
        val signedJWT = SignedJWT.parse(token)
        return signedJWT.verify(ECDSAVerifier(tokenFactory.key.toECPublicKey()))
    }

    private fun getAuthentication(token: String): Authentication {
        // TODO find correct user
        val ud: UserDetails = User("username", "pw", listOf(JWTAuthority("Authority")))
        return UsernamePasswordAuthenticationToken(ud, "", ud.authorities)
    }
}