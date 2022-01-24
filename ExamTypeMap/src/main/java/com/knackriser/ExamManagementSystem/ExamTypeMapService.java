package com.knackriser.ExamManagementSystem;
import java.util.List;
 
import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
@Transactional
public class ExamTypeMapService {
 
    @Autowired
    private ExamTypeMapRepository repo;
     
    public List<ExamTypeMap> listAll() {
        return repo.findAll();
    }
     
    public void save(ExamTypeMap ExamTypeMap) {
        repo.save(ExamTypeMap);
    }
    public ExamTypeMap get(Long examTypeMapId) {
        return repo.findById(examTypeMapId).get();
    }
     
    public void delete(Long examTypeMapId) {
        repo.deleteById(examTypeMapId);
    }

	
     
}