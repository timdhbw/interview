package com.signicat.interview.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(basePackages = ["com.signicat.interview.jpa.repositories"])
class DatabaseConfiguration {
}