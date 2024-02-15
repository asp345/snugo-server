package com.wafflestudio.snugo.user.model

import com.wafflestudio.snugo.dept.model.Department
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "user")
class User(
	@Id
	val id: String? = null,
	var token: String? = null,
	val nickname: String,
	val department: Department
)
