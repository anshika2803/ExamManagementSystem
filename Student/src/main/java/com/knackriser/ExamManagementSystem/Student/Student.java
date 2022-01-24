package com.knackriser.ExamManagementSystem.Student;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="student")
@Entity
public class Student {
   
	private @Id @GeneratedValue(strategy=GenerationType.IDENTITY)  Long studentId;
	private String studentName;
	private String studentEmail;
	private Long studentMobile;
	private String regDate;


	
	Student(){}
	Student(String studentName,String studentEmail, Long studentMobile, String regDate){
		this.studentName = studentName;	
		this.studentEmail = studentEmail;
		this.studentMobile = studentMobile;
		this.regDate = regDate;
	}
	
	public Long getStudentId() {
		return studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public Long getStudentMobile() {
		return studentMobile;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;	
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;	
	}
	public void setStudentMobile(Long studentMobile) {
		this.studentMobile = studentMobile;	
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
}