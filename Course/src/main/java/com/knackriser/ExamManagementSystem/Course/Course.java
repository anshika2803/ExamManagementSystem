package com.knackriser.ExamManagementSystem.Course;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="course")
@Entity
public class Course {
   
	private @Id @GeneratedValue(strategy=GenerationType.IDENTITY)  Long courseId;
	private String courseName;
	private String courseCode;

	
	Course(){}
	Course(String courseName,String courseCode){
		this.courseName = courseName;	
		this.courseCode = courseCode;
	}
	
	public Long getCourseId() {
		return courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;	
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	
}