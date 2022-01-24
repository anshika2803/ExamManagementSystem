package com.knackriser.ExamManagementSystem.Subcourse;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="subcourse")
@Entity
public class Subcourse {
   
	private @Id @GeneratedValue(strategy=GenerationType.IDENTITY)  Long subcourseId;
	private String subcourseName;
	private String courseName;

	
	Subcourse(){}
	Subcourse(String subcourseName,String courseName){
		this.subcourseName = subcourseName;	
		this.courseName = courseName;
	}
	
	public Long getSubcourseId() {
		return subcourseId;
	}
	public String getSubcourseName() {
		return subcourseName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setSubcourseId(Long subcourseId) {
		this.subcourseId = subcourseId;
	}
	public void setSubcourseName(String subcourseName) {
		this.subcourseName = subcourseName;	
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
}