package com.knackriser.ExamManagementSystem.Exam;
import java.util.List;
 
import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
@Transactional
public class ExamService {
 
    @Autowired
    private ExamRepository repo;
     
    public List<Exam> listAll() {
        return repo.findAll();
    }
     
    public void save(Exam exam) {
        repo.save(exam);
    }
    public Exam get(Long examId) {
        return repo.findById(examId).get();
    }
     
    public void delete(Long examId) {
        repo.deleteById(examId);
    }

	
     
}