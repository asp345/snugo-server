package com.wafflestudio.snugo.user.repository

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long> {
	fun findByToken(token: String): UserEntity?
}
