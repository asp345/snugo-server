package com.wafflestudio.snugo.common.auth.controller

import com.wafflestudio.snugo.common.auth.model.SignupRequest
import com.wafflestudio.snugo.common.auth.model.TokenResponse
import com.wafflestudio.snugo.common.auth.service.AuthService
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
	fun signup(@RequestBody request: SignupRequest): TokenResponse {
		return authService.generateToken(request)
	}
}
