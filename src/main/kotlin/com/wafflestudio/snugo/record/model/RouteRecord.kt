package com.wafflestudio.snugo.record.model

import com.wafflestudio.snugo.location.model.Building
import com.wafflestudio.snugo.location.model.LatLng
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "routerecord")
data class RouteRecord(
	@Id
	val id: String,
	val uid: String,
	val nickname: String,
	val buildings: List<Building>,
	val path: List<Pair<Long, LatLng>>, // 타임스탬프 + 위경도
	val startTime: Long,
	val duration: Long,
)
