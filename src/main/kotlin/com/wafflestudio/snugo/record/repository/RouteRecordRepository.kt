package com.wafflestudio.snugo.record.repository

import com.wafflestudio.snugo.record.model.RouteRecord
import org.springframework.data.mongodb.repository.MongoRepository

interface RouteRecordRepository : MongoRepository<RouteRecord, String> {
	fun findAllByNickname(nickname: String): List<RouteRecord>
}
