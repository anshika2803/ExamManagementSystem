package com.knackriser.ExamManagementSystem.Topic;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="topic")
@Entity
public class Topic {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long topicId;
	private String topicName;
	private String subjectName;

	
	Topic(){}
	Topic(String topicName,String subjectName){
		this.topicName = topicName;
		this.subjectName = subjectName;
		
	}
	public Long getTopicId() {
		return topicId;
	}
	public String getTopicName() {
		return topicName;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	}