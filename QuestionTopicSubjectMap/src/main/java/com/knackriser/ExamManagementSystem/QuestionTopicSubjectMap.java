package com.knackriser.ExamManagementSystem;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Table(name="questiontopicsubjectmap")
@Entity


class QuestionTopicSubjectMap {
    
	 @Id @GeneratedValue
	 @OneToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="questionId", nullable=true)
	private int questionTopicSubjectId;
	private int questionId;
	private int topicId;
	private int subjectId;
	
	QuestionTopicSubjectMap(){}
	QuestionTopicSubjectMap(int questionId, int topicId, int subjectId)
	{

		this.questionId = questionId;
		this.topicId = topicId;
		this.subjectId = subjectId;
		
	}
	
	
	public int getQuestionTopicSubjectId() {
		return questionTopicSubjectId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public int getTopicId() {
		return topicId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setQuestionTopicSubjectId(int questionTopicSubjectId) {
		this.questionTopicSubjectId = questionTopicSubjectId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	
}