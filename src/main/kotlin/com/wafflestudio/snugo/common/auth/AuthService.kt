package com.wafflestudio.snugo.common.auth

import com.wafflestudio.snugo.common.auth.model.LoginRequest
import com.wafflestudio.snugo.common.auth.model.LoginResponse
import com.wafflestudio.snugo.user.repository.UserRepository
import org.springframework.stereotype.Service
import javax.security.auth.login.LoginException

@Service
class AuthService(
	private val tokenGenerator: TokenGenerator,
	private val userRepository: UserRepository
) {
	fun login(email: String, password: String): LoginResponse {
		val user = userRepository.findByEmail(email) ?: throw LoginException("User not found")
		return LoginResponse(tokenGenerator.generateToken(user.id))
	}
}
