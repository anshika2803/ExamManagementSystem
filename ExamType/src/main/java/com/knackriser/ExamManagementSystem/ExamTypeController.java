package com.knackriser.ExamManagementSystem;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
@RestController
public class ExamTypeController {
 
    @Autowired
    private ExamTypeService service;
     
    // RESTful API methods for Retrieval operations
    
    @GetMapping("/examType")
    public List<ExamType> list() {
        return service.listAll();
    }
    @GetMapping("/examType/{examTypeId}")
    public ResponseEntity<ExamType> get(@PathVariable Long examTypeId) {
        try {
        	ExamType ExamType = service.get(examTypeId);
            return new ResponseEntity<ExamType>(ExamType, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<ExamType>(HttpStatus.NOT_FOUND);
        }      
    }
     
    // RESTful API method for Create operation
    @PostMapping("/examType")
    public void add(@RequestBody ExamType ExamType) {
        service.save(ExamType);
    } 
    
    // RESTful API method for Update operation
    
    @PutMapping("/examType/{examTypeId}")
    public ResponseEntity<?> update(@RequestBody ExamType ExamType, @PathVariable Long examTypeId) {
        try {
        	ExamType existExamType = service.get(examTypeId);
            service.save(ExamType);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }
     
    // RESTful API method for Delete operation
    @DeleteMapping("/examType/{examTypeId}")
    public void delete(@PathVariable Long examTypeId) {
        service.delete(examTypeId);
    }
    
    
}