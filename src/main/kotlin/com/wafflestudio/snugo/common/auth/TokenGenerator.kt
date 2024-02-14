package com.wafflestudio.snugo.common.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class TokenGenerator(
	@Value("\${jwt.secret}") private val secret: String,
) {
	private val algo = Algorithm.HMAC256(Base64.getDecoder().decode(secret))
	fun generateToken(uid: Long, nickname: String, department: String): String {
		val jwt = JWT.create()
			.withClaim("uid", uid)
			.withClaim("nickname", nickname)
			.withClaim("department", department)
		return jwt.sign(algo)
	}
}
