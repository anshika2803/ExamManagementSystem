package com.knackriser.ExamManagementSystem.Passage;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="passage")
@Entity
public class Passage {
   
	private @Id @GeneratedValue(strategy=GenerationType.IDENTITY)  Long passageId;
	private String passageName;
	private String language;

	
	Passage(){}
	Passage(String passageName,String language){
		this.passageName = passageName;	
		this.language = language;
	}
	
	public Long getPassageId() {
		return passageId;
	}
	public String getPassageName() {
		return passageName;
	}
	public String getLanguage() {
		return language;
	}
	public void setPassageId(Long passageId) {
		this.passageId = passageId;
	}
	public void setPassageName(String passageName) {
		this.passageName = passageName;	
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
}