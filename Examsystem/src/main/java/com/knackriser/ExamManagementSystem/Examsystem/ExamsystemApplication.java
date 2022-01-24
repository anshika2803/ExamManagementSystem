package com.knackriser.ExamManagementSystem.Examsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.knackriser.ExamManagementSystem.Subject","com.knackriser.ExamManagementSystem.Topic","com.knackriser.ExamManagementSystem.Course","com.knackriser.ExamManagementSystem.Subcourse","com.knackriser.ExamManagementSystem.Student","com.knackriser.ExamManagementSystem.Passage","com.knackriser.ExamManagementSystem.Question","com.knackriser.ExamManagementSystem.News","com.knackriser.ExamManagementSystem.Test","com.knackriser.ExamManagementSystem.Document"})
public class ExamsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamsystemApplication.class, args);
	}

}
