package com.wafflestudio.snugo.record.service

import com.wafflestudio.snugo.record.model.Record
import org.springframework.stereotype.Service

@Service
class RecordService {
	fun getMyRecord(userId: Long): Record {
		return Record(
			id = "1",
			nickname = "nickname",
			buildings = listOf(),
			path = listOf(),
			startTime = 0,
			duration = 0
		)
	}
}
