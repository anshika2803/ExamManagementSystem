package com.knackriser.ExamManagementSystem;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
@RestController
public class QuestionTrackerController {
 
    @Autowired
    private QuestionTrackerService service;
     
    // RESTful API methods for Retrieval operations
    @GetMapping("/QuestionTracker")
    public List<QuestionTracker> list() {
        return service.listAll();
    }
    @GetMapping("/QuestionTracker/{questionTrackerId}")
    public ResponseEntity<QuestionTracker> get(@PathVariable Long questionTrackerId) {
        try {
        	QuestionTracker qt = service.get(questionTrackerId);
            return new ResponseEntity<QuestionTracker>(qt, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<QuestionTracker>(HttpStatus.NOT_FOUND);
        }      
    }
     
    // RESTful API method for Create operation
    @PostMapping("/QuestionTracker")
    public void add(@RequestBody QuestionTracker qt) {
        service.save(qt);
    } 
     
    // RESTful API method for Update operation
    
    @PutMapping("/QuestionTracker/{questionTrackerId}")
    public ResponseEntity<?> update(@RequestBody QuestionTracker qt, @PathVariable Long questionTrackerId) {
        try {
        	QuestionTracker existQuestionTracker = service.get(questionTrackerId);
            service.save(qt);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }
     
    // RESTful API method for Delete operation
    @DeleteMapping("/QuestionTracker/{questionTrackerId}")
    public void delete(@PathVariable Long questionTrackerId) {
        service.delete(questionTrackerId);
    }
    
    
}