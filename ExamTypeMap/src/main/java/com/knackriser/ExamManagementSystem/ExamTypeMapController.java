package com.knackriser.ExamManagementSystem;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
@RestController
public class ExamTypeMapController {
 
    @Autowired
    private ExamTypeMapService service;
     
    // RESTful API methods for Retrieval operations
    
    @GetMapping("/examTypeMap")
    public List<ExamTypeMap> list() {
        return service.listAll();
    }
    @GetMapping("/examTypeMap/{examTypeMapId}")
    public ResponseEntity<ExamTypeMap> get(@PathVariable Long examTypeMapId) {
        try {
        	ExamTypeMap ExamTypeMap = service.get(examTypeMapId);
            return new ResponseEntity<ExamTypeMap>(ExamTypeMap, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<ExamTypeMap>(HttpStatus.NOT_FOUND);
        }      
    }
     
    // RESTful API method for Create operation
    @PostMapping("/examTypeMap")
    public void add(@RequestBody ExamTypeMap ExamTypeMap) {
        service.save(ExamTypeMap);
    } 
    
    // RESTful API method for Update operation
    
    @PutMapping("/examTypeMap/{examTypeMapId}")
    public ResponseEntity<?> update(@RequestBody ExamTypeMap ExamTypeMap, @PathVariable Long examTypeMapId) {
        try {
        	ExamTypeMap existExamTypeMap = service.get(examTypeMapId);
            service.save(ExamTypeMap);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }
     
    // RESTful API method for Delete operation
    @DeleteMapping("/examTypeMap/{examTypeMapId}")
    public void delete(@PathVariable Long examTypeMapId) {
        service.delete(examTypeMapId);
    }
    
    
}