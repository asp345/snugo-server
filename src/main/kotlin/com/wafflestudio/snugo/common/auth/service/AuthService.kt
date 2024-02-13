package com.wafflestudio.snugo.common.auth.service

import com.wafflestudio.snugo.common.auth.TokenGenerator
import org.springframework.stereotype.Service

@Service
class AuthService(
	private val tokenGenerator: TokenGenerator,
) {
	fun createToken(userId: Long): String {
		return tokenGenerator.generateToken(userId)
	}
}
