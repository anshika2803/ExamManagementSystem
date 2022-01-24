package com.knackriser.ExamManagementSystem;

import java.util.List;
 
import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
@Transactional
public class QuestionTrackerService {
 
    @Autowired
    private QuestionTrackerRepository repo;
     
    public List<QuestionTracker> listAll() {
        return repo.findAll();
    }
     
    public void save(QuestionTracker qt) {
        repo.save(qt);
    }
    public QuestionTracker get(Long questionTrackerId) {
        return repo.findById(questionTrackerId).get();
    }
     
    public void delete(Long questionTrackerId) {
        repo.deleteById(questionTrackerId);
    }

	
     
}