package com.wafflestudio.snugo.dept.controller

import com.wafflestudio.snugo.dept.model.Department
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DepartmentController {
	@GetMapping("/v1/departments")
	fun getDepartments(): List<String> {
		return Department.entries.map { it.value }
	}
}
