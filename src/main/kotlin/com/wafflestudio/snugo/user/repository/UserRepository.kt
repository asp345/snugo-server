package com.wafflestudio.snugo.user.repository

import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, Long> {
	fun findByToken(token: String): User?
	fun findByNickname(nickname: String): User?
}
