package com.knackriser.ExamManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ExamTypeMapApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamTypeMapApplication.class, args);
	}

}
