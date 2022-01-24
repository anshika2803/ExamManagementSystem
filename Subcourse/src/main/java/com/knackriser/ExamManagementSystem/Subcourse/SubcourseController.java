package com.knackriser.ExamManagementSystem.Subcourse;

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
@RequestMapping("/subcourse")
public class SubcourseController {

	@Autowired
	private SubcourseRepository scr;
	
	// get all 
	@GetMapping("/subcourse")
	public List<Subcourse> getAllSubcourses(){
		return scr.findAll();
	}		
	
	// create  rest API
	@PostMapping("/subcourse")
	public Subcourse createSubcourse(@RequestBody Subcourse subcourse) {
		return scr.save(subcourse);
	}
	
	// get  by id rest API
	@GetMapping("/subcourse/{subcourseId}")
	public ResponseEntity<Subcourse> getCourseById(@PathVariable Long subcourseId) {
		Subcourse subcourse = scr.findById(subcourseId)
				.orElseThrow(() -> new ResourceNotFoundException("SubCourse not exist with id :" + subcourseId));
		return ResponseEntity.ok(subcourse);
	}
	
	// update  rest API
	
	@PutMapping("/subcourse/{subcourseId}")
	public ResponseEntity<Subcourse> updateSubcourse(@PathVariable Long subcourseId, @RequestBody Subcourse subcourseDetails){
		Subcourse subcourse = scr.findById(subcourseId)
				.orElseThrow(() -> new ResourceNotFoundException("SubCourse not exist with id :" + subcourseId));
		
		subcourse.setSubcourseName(subcourseDetails.getSubcourseName());
    	subcourse.setCourseName(subcourseDetails.getCourseName());
    	
		
    	Subcourse updatedSubcourse = scr.save(subcourse);
    	return ResponseEntity.ok(updatedSubcourse);
	}
	
	// delete  rest API
	@DeleteMapping("/subcourse/{subcourseId}")
	public ResponseEntity<Map<String, Boolean>> deleteSubcourse(@PathVariable Long subcourseId){
		Subcourse subcourse = scr.findById(subcourseId)
				.orElseThrow(() -> new ResourceNotFoundException("SubCourse not exist with id :" + subcourseId));
		
		scr.delete(subcourse);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}