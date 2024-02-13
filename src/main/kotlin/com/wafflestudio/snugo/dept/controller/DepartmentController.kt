package com.wafflestudio.snugo.dept.controller

import com.wafflestudio.snugo.dept.model.Department
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/departments")
class DepartmentController {
	@GetMapping("")
	fun getDepartments(): List<String> {
		return Department.entries.map { it.value }
	}
}
