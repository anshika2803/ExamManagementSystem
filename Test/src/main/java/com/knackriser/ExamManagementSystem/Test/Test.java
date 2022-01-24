package com.knackriser.ExamManagementSystem.Test;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="test")
@Entity
public class Test  {
   
	private @Id @GeneratedValue(strategy=GenerationType.IDENTITY)  Long testId;
	private String testName;
	private String courseName;
	private String openDate;
	private String closeDate;
	private int numOfQuestions;
	private String status;
	private String featured;
	
	Test(){}
	Test(String testName,String courseName,String openDate, String closeDate,int numOfQuestions,String status,String featured){
		this.testName=testName;
		this.courseName = courseName;
		this.openDate = openDate;	
		this.closeDate = closeDate;	
		this.numOfQuestions = numOfQuestions;	
		this.status = status;	
		this.featured = featured;	

	}
	
	public Long getTestId() {
		return testId;
	}
	public String getTestName() {
		return testName;
	}
	public String getCourseName() {
		return courseName;
	}
	public String getOpenDate() {
		return openDate;
	}
	public String getCloseDate() {
		return closeDate;
	}
	public int getNumOfQuestions() {
		return numOfQuestions;
	}
	public String getStatus() {
		return status;
	}
	public String getFeatured() {
		return featured;
	}
	public void setTestId(Long testId) {
		this.testId = testId;
	}
	public void setTestName(String testName) {
		this.testName = testName;	
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;	
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}
	public void setNumOfQuestions(int numOfQuestions) {
		this.numOfQuestions = numOfQuestions;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setFeatured(String featured) {
		this.featured = featured;
	}
	
	
}