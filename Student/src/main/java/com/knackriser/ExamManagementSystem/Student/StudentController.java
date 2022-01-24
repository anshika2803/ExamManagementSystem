package com.knackriser.ExamManagementSystem.Student;

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
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentRepository sr;
	
	// get all 
	@GetMapping("/student")
	public List<Student> getAllStudents(){
		return sr.findAll();
	}		
	
	// create  rest API
	@PostMapping("/student")
	public Student createStudent(@RequestBody Student student) {
		return sr.save(student);
	}
	
	// get  by id rest API
	@GetMapping("/student/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
		Student student = sr.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + studentId));
		return ResponseEntity.ok(student);
	}
	
	// update  rest API
	
	@PutMapping("/student/{studentId}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long studentId, @RequestBody Student studentDetails){
		Student student = sr.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + studentId));
		
		student.setStudentName(studentDetails.getStudentName());
		student.setStudentEmail(studentDetails.getStudentEmail());
		student.setStudentMobile(studentDetails.getStudentMobile());
		student.setRegDate(studentDetails.getRegDate());
    	
		
		Student updatedStudent = sr.save(student);
    	return ResponseEntity.ok(updatedStudent);
	}
	
	// delete  rest API
	@DeleteMapping("/student/{studentId}")
	public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long studentId){
		Student student = sr.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + studentId));
		
		sr.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}