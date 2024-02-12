package com.wafflestudio.snugo.user.repository

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long> {
	fun findByEmail(email: String): UserEntity?
	fun existsByEmail(email: String): Boolean
}
