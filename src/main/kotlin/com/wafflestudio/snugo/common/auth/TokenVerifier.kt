package com.wafflestudio.snugo.common.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT
import com.wafflestudio.snugo.common.auth.model.AuthUserInfo
import io.github.oshai.kotlinlogging.KLogger
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

private val logger: KLogger = KotlinLogging.logger {}

@Component
class TokenVerifier(
	@Value("\${jwt.secret}") private val secretKey: String,
) {
	private val decoder: Base64.Decoder = Base64.getUrlDecoder()
	private val secretKeyBytes = decoder.decode(secretKey)
	private val algorithm: Algorithm = Algorithm.HMAC256(secretKeyBytes)
	private val jwtVerifier: JWTVerifier = initVerifier()

	fun verifyJWT(token: String): AuthUserInfo {
		val decodedJWT = jwtVerifier.verify(token)
		return createAuthUserInfo(decodedJWT)
	}

	private fun createAuthUserInfo(token: DecodedJWT): AuthUserInfo {
		val uid = token.getClaim("uid")?.asLong()!!
		val nickname = token.getClaim("nickname")?.asString()!!
		val department = token.getClaim("department")?.asString()!!
		return AuthUserInfo(uid, nickname, department)
	}

	private fun initVerifier(): JWTVerifier {
		return JWT.require(algorithm)
			.withClaimPresence("uid")
			.withClaimPresence("nickname")
			.withClaimPresence("department")
			.build()
	}

}
