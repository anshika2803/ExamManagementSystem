package com.knackriser.ExamManagementSystem.News;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="news")
@Entity
public class News {
   
	private @Id @GeneratedValue(strategy=GenerationType.IDENTITY)  Long newsId;
	private String fileName;
	private String exam;
	private String newsType;

	
	News(){}
	News(String fileName,String exam,String newsType){
		this.fileName = fileName;	
		this.exam = exam;
		this.newsType = newsType;

	}
	
	public Long getNewsId() {
		return newsId;
	}
	public String getFileName() {
		return fileName;
	}
	public String getExam() {
		return exam;
	}
	public String getNewsType() {
		return newsType;
	}
	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;	
	}
	public void setExam(String exam) {
		this.exam = exam;
	}
	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}
	
	
}