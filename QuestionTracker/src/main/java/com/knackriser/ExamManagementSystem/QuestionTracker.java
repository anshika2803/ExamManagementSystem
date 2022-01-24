package com.knackriser.ExamManagementSystem;


import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Table(name="questiontracker")
@Entity
public class QuestionTracker {
    
	private @Id @GeneratedValue Long questionTrackerId;
    private int questionId;
	private int userId;
	private boolean status;
	private Date creationDate;
	private Date deletedDate;
	private String deleteType;
	
	
	QuestionTracker(){}
	QuestionTracker(int questionId,int userId,boolean status,Date creationDate,Date deletedDate,String deleteType){
		this.questionId = questionId;
		this.userId=userId;
		this.status = status;
		this.creationDate = creationDate;
		this.deletedDate = deletedDate;
		this.deleteType = deleteType;

		
	}
	

	public Long getQuestionTrackerId() {
		return questionTrackerId;
	}
	
	public int getQuestionid() {
		return questionId;
	}

	public int getUserId() {
		return userId;
	}
	public boolean isStatus() {
		return status;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public Date getdeletedDate() {
		return deletedDate;
		
	}
	public String getDeleteType() {
		return deleteType;
	}
	public void setQuestionTrackerId(Long questionTrackerId) {
		this.questionTrackerId = questionTrackerId;
	}

	public void setQuestionid(int questionId) {
		this.questionId = questionId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;

	}
	public void setdeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}
	public void setDeleteType(String deleteType) {
		this.deleteType = deleteType;
	}
	
	}
