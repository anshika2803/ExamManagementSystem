package com.knackriser.ExamManagementSystem.Test;

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

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestRepository tr;
	
	// get all 
	@GetMapping("/test")
	public List<Test> getAllTests(){
		return tr.findAll();
	}		
	
	// create  rest API
	@PostMapping("/test")
	public Test createTest(@RequestBody Test test) {
		return tr.save(test);
	}
	
	// get  by id rest API
	@GetMapping("/test/{testId}")
	public ResponseEntity<Test> getTestById(@PathVariable Long testId) {
		Test test = tr.findById(testId)
				.orElseThrow(() -> new ResourceNotFoundException("Test not exist with id :" + testId));
		return ResponseEntity.ok(test);
	}
	
	// update  rest API
	
	@PutMapping("/test/{testId}")
	public ResponseEntity<Test> updateTest(@PathVariable Long testId, @RequestBody Test testDetails){
		Test test = tr.findById(testId)
				.orElseThrow(() -> new ResourceNotFoundException("Test not exist with id :" + testId));
		
		test.setTestName(testDetails.getTestName());
    	test.setCourseName(testDetails.getCourseName());
    	test.setOpenDate(testDetails.getOpenDate());
    	test.setCloseDate(testDetails.getCloseDate());
    	test.setNumOfQuestions(testDetails.getNumOfQuestions());
    	test.setStatus(testDetails.getStatus());
    	test.setFeatured(testDetails.getFeatured());

		
    	Test updatedTest = tr.save(test);
    	return ResponseEntity.ok(updatedTest);
	}
	
	// delete  rest API
	@DeleteMapping("/test/{testId}")
	public ResponseEntity<Map<String, Boolean>> deleteTest(@PathVariable Long testId){
		Test test = tr.findById(testId)
				.orElseThrow(() -> new ResourceNotFoundException("Test not exist with id :" + testId));
		
		tr.delete(test);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}