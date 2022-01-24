package com.knackriser.ExamManagementSystem.Question;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="question")
@Entity
public class Question {
   
	private @Id @GeneratedValue(strategy=GenerationType.IDENTITY)Long questionId;
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String subjectName;
	private String questionType;

	
	Question(){}
	Question(String question,String option1,String option2,String option3,String option4,String subjectName,String questionType){
		this.question = question;
    	this.option1 = option1;
    	this.option2 = option2;
    	this.option3 = option3;
    	this.option4= option4;
    	this.subjectName = subjectName;
    	this.questionType = questionType;
	}
	
	public Long getQuestionId() {
		return questionId;
	}
	public String getQuestion() {
		return question;
	}
	public String getOption1() {
		return option1;
	}
	public String getOption2() {
		return option2;
	}
	public String getOption3() {
		return option3;
	}
	public String getOption4() {
		return option4;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	
}