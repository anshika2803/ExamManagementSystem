package com.knackriser.ExamManagementSystem;
import java.util.List;
 
import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
@Transactional
public class QuestionTopicSubjectMapService {
 
    @Autowired
    private QuestionTopicSubjectMapRepository repo;
     
    public List<QuestionTopicSubjectMap> listAll() {
        return repo.findAll();
    }
     
    public void save(QuestionTopicSubjectMap questiontopicsubjectmap) {
        repo.save(questiontopicsubjectmap);
    }
    public QuestionTopicSubjectMap get(Long questionTopicSubjectId) {
        return repo.findById(questionTopicSubjectId).get();
    }
     
    public void delete(Long questionTopicSubjectId) {
        repo.deleteById(questionTopicSubjectId);
    }

	
     
}