package com.knackriser.ExamManagementSystem.Subject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins ="http://localhost:3000")
@RequestMapping("/subject")
public class SubjectController {
 
	@Autowired
	private SubjectRepository sr;
	
	// get all 
	@GetMapping("/subject")
	public List<Subject> getAllSubject(){
		return sr.findAll();
	}		
	
	// create  rest API
	@PostMapping("/subject")
	public Subject createSubject(@RequestBody Subject subject) {
		return sr.save(subject);
	}
	
	// get  by id rest API
	@GetMapping("/subject/{subjectId}")
	public ResponseEntity<Subject> getSubjectById(@PathVariable Long subjectId) {
		Subject subject = sr.findById(subjectId)
				.orElseThrow(() -> new ResourceNotFoundException("Subject not exist with id :" + subjectId));
		return ResponseEntity.ok(subject);
	}
	
	// update  rest API
	
	@PutMapping("/subject/{subjectId}")
	public ResponseEntity<Subject> updateCourse(@PathVariable Long subjectId, @RequestBody Subject subjectDetails){
		Subject subject = sr.findById(subjectId)
				.orElseThrow(() -> new ResourceNotFoundException("Subject not exist with id :" + subjectId));
		
		subject.setSubjectName(subjectDetails.getSubjectName());
    	
		
		Subject updatedSubject = sr.save(subject);
    	return ResponseEntity.ok(updatedSubject);
	}
	
	// delete  rest API
	@DeleteMapping("/subject/{subjectId}")
	public ResponseEntity<Map<String, Boolean>> deleteSubject(@PathVariable Long subjectId){
		Subject subject = sr.findById(subjectId)
				.orElseThrow(() -> new ResourceNotFoundException("Subject not exist with id :" + subjectId));
		
		sr.delete(subject);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
    
    
}