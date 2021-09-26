package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableAsync
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
