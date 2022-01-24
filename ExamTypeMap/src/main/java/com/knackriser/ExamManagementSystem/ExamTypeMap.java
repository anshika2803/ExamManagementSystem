package com.knackriser.ExamManagementSystem;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="examtypemap")
public class ExamTypeMap {
    
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long examTypeMapId;
    @Column
	private int examId;
    @Column
	private int examTypeId;
    
    ExamTypeMap(){}
	ExamTypeMap(int examId, int examTypeId){
		this.examId = examId;
	    this.examTypeId = examTypeId;	
	}
	
	
	public long getExamTypeMapId() {
		return examTypeMapId;
	}
	public int getExamId() {
		return examId;
	}
	public int getExamTypeId() {
		return examTypeId;
	}
	public void setExamTypeMapId(long examTypeMapId) {
		this.examTypeMapId = examTypeMapId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public void setExamTypeId(int examTypeId) {
		this.examTypeId = examTypeId;
	}
	
	

}
