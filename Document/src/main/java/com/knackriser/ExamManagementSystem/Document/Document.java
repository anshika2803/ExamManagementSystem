package com.knackriser.ExamManagementSystem.Document;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="document")
@Entity
public class Document {
   
	private @Id @GeneratedValue(strategy=GenerationType.IDENTITY)  Long documentId;
	private String fileName;
	private String fileType;
	private String documentType;
	private String courseName;
	private String center;

	Document(){}
	Document(String fileName,String fileType,String documentType,String courseName,String center){
		this.fileName = fileName;
		this.fileType = fileType;
		this.documentType = documentType;
		this.courseName = courseName;
		this.center = center;
	}
	
	public Long getDocumentId() {
		return documentId;
	}
	public String getFileName() {
		return fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public String getDocumentType() {
		return documentType;
	}
	public String getCourseName() {
		return courseName;
	}
	public String getCenter() {
		return center;
	}
	
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;	
	}
	public void setCenter(String center) {
		this.center = center;
	}
	
	
}