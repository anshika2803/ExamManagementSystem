package com.knackriser.ExamManagementSystem.Subject;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="subject")
@Entity
public class Subject {
   
	private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long subjectId;
	private String subjectName;
	
	Subject(){}
	Subject(String subjectName){
		this.subjectName = subjectName;		
	}
	
	public Long getSubjectId() {
		return subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	
}