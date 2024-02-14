package com.wafflestudio.snugo.record.repository

import org.springframework.data.mongodb.repository.MongoRepository

interface RecordRepository : MongoRepository<Record, String>
