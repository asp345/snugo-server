package com.wafflestudio.snugo.user.service

import com.wafflestudio.snugo.common.auth.service.AuthService
import com.wafflestudio.snugo.dept.model.Department
import com.wafflestudio.snugo.user.model.TokenResponse
import com.wafflestudio.snugo.user.repository.UserEntity
import com.wafflestudio.snugo.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
	private val authService: AuthService,
	private val userRepository: UserRepository
) {
	fun register(nickname: String, department: String): TokenResponse {
		userRepository.findByNickname(nickname)?.let {
			throw IllegalArgumentException("Nickname already exists")
		} ?: run {
			val user = userRepository.save(
				UserEntity(
					nickname = nickname,
					department = Department.valueOf(department)
				)
			)
			user.token = authService.createToken(user.id!!)
			userRepository.save(user)
			return user.token?.let { TokenResponse(it) } ?: throw IllegalStateException("Token is null")
		}
	}
}
