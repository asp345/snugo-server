package com.wafflestudio.snugo.user.repository

import com.wafflestudio.snugo.dept.model.Department
import jakarta.persistence.*

@Entity(name = "user")
class UserEntity(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long? = null,
	var token: String? = null,
	val nickname: String,
	@Enumerated(EnumType.STRING)
	val department: Department
)
