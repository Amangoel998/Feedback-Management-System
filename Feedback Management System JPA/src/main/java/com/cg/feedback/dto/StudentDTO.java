package com.cg.feedback.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class StudentDTO {

	@Id
	@Column(name="studentid", updatable=false)
	private String studentId;
	
	@Column(name="studentname", updatable=false)
	private String studentName;
	
	@Column(name="studentemail")
	private String studentEmail;
	
	@Column(name="batch")
	private String batch;
	
	//Constructor
	
	public StudentDTO(String studentId, String studentName, String studentEmail, String batch) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.batch = batch;
	}
	
	
	//getter and Setters

	public StudentDTO() {
		super();
	}


	@Override
	public String toString() {
		return "StudentDTO [studentId=" + studentId + ", studentName=" + studentName + 
				", studentEmail=" + studentEmail + ", batch=" + batch + "]";
	}


	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	@Override
	public boolean equals(Object obj) {
		StudentDTO temp = (StudentDTO) obj;
		if(temp.getStudentEmail().equals(this.studentEmail))
			return true;
		return false;
	}
	
}
