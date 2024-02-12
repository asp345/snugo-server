package com.wafflestudio.snugo.user.repository

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "user")
class UserEntity(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long? = null,
	var token: String? = null,
	val nickname: String,
	val department: Department
) {
	enum class Department {
		ENGINEERING, BUSINESS, DESIGN, HUMANITIES, SOCIAL_SCIENCE, NATURAL_SCIENCE
	}
}
