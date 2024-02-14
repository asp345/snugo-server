package com.wafflestudio.snugo.record.model

import com.wafflestudio.snugo.location.model.Building
import com.wafflestudio.snugo.location.model.LatLng

data class Record(
	val id: String,
	val nickname: String,
	val buildings: List<Building>,
	val path: List<Pair<Long, LatLng>>, // 타임스탬프 + 위경도
	val startTime: Long,
	val duration: Long,
)
