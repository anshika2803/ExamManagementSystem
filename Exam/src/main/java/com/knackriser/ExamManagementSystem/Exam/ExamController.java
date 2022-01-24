package com.knackriser.ExamManagementSystem.Exam;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
@RestController
public class ExamController {
 
    @Autowired
    private ExamService service;
     
    // RESTful API methods for Retrieval operations
    
    @GetMapping("/exam")
    public List<Exam> list() {
        return service.listAll();
    }
    @GetMapping("/exam/{examId}")
    public ResponseEntity<Exam> get(@PathVariable Long examId) {
        try {
        	Exam exam = service.get(examId);
            return new ResponseEntity<Exam>(exam, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Exam>(HttpStatus.NOT_FOUND);
        }      
    }
     
    // RESTful API method for Create operation
    @PostMapping("/exam")
    public void add(@RequestBody Exam exam) {
        service.save(exam);
    } 
    
    // RESTful API method for Update operation
    
    @PutMapping("/exam/{examId}")
    public ResponseEntity<?> update(@RequestBody Exam exam, @PathVariable Long examId) {
        try {
        	Exam existExam = service.get(examId);
            service.save(exam);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }
     
    // RESTful API method for Delete operation
    @DeleteMapping("/exam/{examId}")
    public void delete(@PathVariable Long examId) {
        service.delete(examId);
    }
    
    
}