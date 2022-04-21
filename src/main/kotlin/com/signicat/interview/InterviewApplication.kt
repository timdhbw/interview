package com.signicat.interview

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class InterviewApplication

fun main(args: Array<String>) {
	runApplication<InterviewApplication>(*args)
}
