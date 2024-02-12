package com.wafflestudio.snugo.common.auth

import com.wafflestudio.snugo.common.auth.model.LoginRequest
import com.wafflestudio.snugo.common.auth.model.LoginResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
	private val authService: AuthService
) {
	@PostMapping("/login")
	fun login(@RequestBody request: LoginRequest): LoginResponse {
		return authService.login(request.email, request.password)
	}
}
