package com.wafflestudio.snugo.record.controller

import com.wafflestudio.snugo.common.auth.model.AuthUserInfo
import com.wafflestudio.snugo.record.model.RecordListResponse
import com.wafflestudio.snugo.record.service.RecordService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/record")
class RecordController(
	private val recordService: RecordService
) {
	@GetMapping("/my")
	fun getMyRecord(@AuthenticationPrincipal authUserInfo: AuthUserInfo): RecordListResponse {
		val record = recordService.getMyRecord(authUserInfo.uid)
		return RecordListResponse(listOf(record))
	}
}
