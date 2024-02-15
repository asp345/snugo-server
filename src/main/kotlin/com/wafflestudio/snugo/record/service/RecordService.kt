package com.wafflestudio.snugo.record.service

import com.wafflestudio.snugo.record.model.RouteRecord
import com.wafflestudio.snugo.record.repository.RouteRecordRepository
import org.springframework.stereotype.Service

@Service
class RecordService(
	private val routeRecordRepository: RouteRecordRepository
) {
	fun getMyRecordList(userId: Long): List<RouteRecord> {
		return routeRecordRepository.findAllByNickname(userId.toString())
	}
}
