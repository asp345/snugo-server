package com.wafflestudio.snugo.common.auth.service

import com.wafflestudio.snugo.common.auth.TokenGenerator
import com.wafflestudio.snugo.common.auth.model.SignupRequest
import com.wafflestudio.snugo.common.auth.model.TokenResponse
import com.wafflestudio.snugo.user.repository.UserEntity
import com.wafflestudio.snugo.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class AuthService(
	private val tokenGenerator: TokenGenerator,
	private val userRepository: UserRepository
) {
	fun generateToken(request: SignupRequest): TokenResponse {
		val user = UserEntity(
			nickname = request.nickname,
			department = UserEntity.Department.valueOf(request.departmentName)
		)
		userRepository.save(user)
		val token = tokenGenerator.generateToken(user.id!!)
		user.token = token
		userRepository.save(user)
		return TokenResponse(token)
	}
}
