package com.wafflestudio.snugo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SnugoApplication

fun main(args: Array<String>) {
	runApplication<SnugoApplication>(*args)
}
