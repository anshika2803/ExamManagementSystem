package com.knackriser.ExamManagementSystem;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
@RestController
public class QuestionTopicSubjectMapController {
 
    @Autowired
    private QuestionTopicSubjectMapService service;
     
    // RESTful API methods for Retrieval operations
    
    @GetMapping("/QuestionTopicSubjectMap")
    public List<QuestionTopicSubjectMap> list() {
        return service.listAll();
    }
    @GetMapping("/QuestionTopicSubjectMap/{questionTopicSubjectId}")
    public ResponseEntity<QuestionTopicSubjectMap> get(@PathVariable Long questionTopicSubjectId) {
        try {
        	QuestionTopicSubjectMap qtsm = service.get(questionTopicSubjectId);
            return new ResponseEntity<QuestionTopicSubjectMap>(qtsm, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<QuestionTopicSubjectMap>(HttpStatus.NOT_FOUND);
        }      
    }
     
    // RESTful API method for Create operation
    @PostMapping("/QuestionTopicSubjectMap")
    public void add(@RequestBody QuestionTopicSubjectMap qtsm) {
        service.save(qtsm);
    } 
     
    // RESTful API method for Update operation
    
    @PutMapping("/QuestionTopicSubjectMap/{questionTopicSubjectId}")
    public ResponseEntity<?> update(@RequestBody QuestionTopicSubjectMap qtsm, @PathVariable Long questionTopicSubjectId) {
        try {
        	//QuestionTopicSubjectMap existQuestionTopicSubjectMap = service.get(questionTopicSubjectId);
            service.save(qtsm);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }
     
    // RESTful API method for Delete operation
    @DeleteMapping("/QuestionTopicSubjectMap/{questionTopicSubjectId}")
    public void delete(@PathVariable Long questionTopicSubjectId) {
        service.delete(questionTopicSubjectId);
    }
    
    
}