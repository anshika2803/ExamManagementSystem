package com.knackriser.ExamManagementSystem.Course;

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
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseRepository cr;
	
	// get all 
	@GetMapping("/course")
	public List<Course> getAllCourses(){
		return cr.findAll();
	}		
	
	// create  rest API
	@PostMapping("/course")
	public Course createCourse(@RequestBody Course course) {
		return cr.save(course);
	}
	
	// get  by id rest API
	@GetMapping("/course/{courseId}")
	public ResponseEntity<Course> getCourseById(@PathVariable Long courseId) {
		Course course = cr.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course not exist with id :" + courseId));
		return ResponseEntity.ok(course);
	}
	
	// update  rest API
	
	@PutMapping("/course/{courseId}")
	public ResponseEntity<Course> updateCourse(@PathVariable Long courseId, @RequestBody Course courseDetails){
		Course course = cr.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course not exist with id :" + courseId));
		
		course.setCourseName(courseDetails.getCourseName());
    	course.setCourseCode(courseDetails.getCourseCode());
    	
		
    	Course updatedCourse = cr.save(course);
    	return ResponseEntity.ok(updatedCourse);
	}
	
	// delete  rest API
	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<Map<String, Boolean>> deleteCourse(@PathVariable Long courseId){
		Course course = cr.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course not exist with id :" + courseId));
		
		cr.delete(course);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}