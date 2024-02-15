package com.wafflestudio.snugo.user.repository

import com.wafflestudio.snugo.user.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, Long> {
	fun findByToken(token: String): User?
	fun findByNickname(nickname: String): User?
}
