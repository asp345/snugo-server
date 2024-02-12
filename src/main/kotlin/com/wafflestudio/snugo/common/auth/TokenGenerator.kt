package com.wafflestudio.snugo.common.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.Base64

@Component
class TokenGenerator(
	@Value("\${jwt.secret}") private val secret: String,
) {
	private val algo = Algorithm.HMAC256(Base64.getDecoder().decode(secret))
	fun generateToken(userId: Long): String {
		val jwt = JWT.create()
			.withClaim("userId", userId)
		return jwt.sign(algo)
	}
}
