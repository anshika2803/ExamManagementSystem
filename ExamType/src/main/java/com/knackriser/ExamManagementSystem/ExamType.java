package com.knackriser.ExamManagementSystem;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="examtype")
public class ExamType {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long examTypeId;
	@Column
	private String examTypes;
	
	ExamType(){}
	ExamType(String examTypes){
		this.examTypes = examTypes;		
	}
	
	public long getExamtypeId() {
		return examTypeId;
	}
	public String getExamTypes() {
		return examTypes;
	}
	public void setExamtypeId(long examTypeId) {
		this.examTypeId = examTypeId;
	}
	public void setExamTypes(String examTypes) {
		this.examTypes = examTypes;
	}
	
}
