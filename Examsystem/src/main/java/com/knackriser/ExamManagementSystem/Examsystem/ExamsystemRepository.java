package com.knackriser.ExamManagementSystem.Examsystem;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EnableJpaRepositories(basePackages = {"com.knackriser.ExamManagementSystem.Subject","com.knackriser.ExamManagementSystem.Topic","com.knackriser.ExamManagementSystem.Course","com.knackriser.ExamManagementSystem.Subcourse","com.knackriser.ExamManagementSystem.Student","com.knackriser.ExamManagementSystem.Passage","com.knackriser.ExamManagementSystem.Question","com.knackriser.ExamManagementSystem.News","com.knackriser.ExamManagementSystem.Test","com.knackriser.ExamManagementSystem.Document"})
@EntityScan(basePackages = {"com.knackriser.ExamManagementSystem.Subject","com.knackriser.ExamManagementSystem.Topic","com.knackriser.ExamManagementSystem.Course","com.knackriser.ExamManagementSystem.Subcourse","com.knackriser.ExamManagementSystem.Student","com.knackriser.ExamManagementSystem.Passage","com.knackriser.ExamManagementSystem.Question","com.knackriser.ExamManagementSystem.News","com.knackriser.ExamManagementSystem.Test","com.knackriser.ExamManagementSystem.Document"})
public interface ExamsystemRepository {

}
