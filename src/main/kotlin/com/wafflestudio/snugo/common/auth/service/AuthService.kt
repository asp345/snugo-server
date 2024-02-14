package com.wafflestudio.snugo.common.auth.service

import com.wafflestudio.snugo.common.auth.TokenGenerator
import io.github.oshai.kotlinlogging.KLogger
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service

private val logger: KLogger = KotlinLogging.logger {}

@Service
class AuthService(
	private val tokenGenerator: TokenGenerator,
)
