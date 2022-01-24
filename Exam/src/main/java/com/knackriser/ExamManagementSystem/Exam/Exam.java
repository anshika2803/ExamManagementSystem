package com.knackriser.ExamManagementSystem.Exam;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exam")
public class Exam {
    
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long examId;
	@Column
	private int questionid;
	
	Exam(){}
	Exam(int questionid){
		this.questionid = questionid;
	}
	
	public long getExamId() {
		return examId;
	}
	public int getQuestionid() {
		return questionid;
	}
	public void setExamId(long examId) {
		this.examId = examId;
	}
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	

	
}
