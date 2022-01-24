package com.knackriser.ExamManagementSystem;
import java.util.List;
 
import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
@Transactional
public class ExamTypeService {
 
    @Autowired
    private ExamTypeRepository repo;
     
    public List<ExamType> listAll() {
        return repo.findAll();
    }
     
    public void save(ExamType ExamType) {
        repo.save(ExamType);
    }
    public ExamType get(Long examTypeId) {
        return repo.findById(examTypeId).get();
    }
     
    public void delete(Long examTypeId) {
        repo.deleteById(examTypeId);
    }

	
     
}