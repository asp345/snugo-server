package com.wafflestudio.snugo.user.repository

import jakarta.persistence.*
@Entity(name = "user")
class UserEntity (
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long,
	val email: String,
	val password: String
)
