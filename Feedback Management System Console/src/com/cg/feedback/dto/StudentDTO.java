package com.cg.feedback.dto;

public class StudentDTO {

	private String studentId;
	private String studentName;
	private String studentPass;
	private String studentEmail;
	private String batch;
	private boolean isActive;

	// Constructor

	public StudentDTO(String studentId, String studentName, String studentPass, String studentEmail, String batch) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentPass = studentPass;
		this.studentEmail = studentEmail;
		this.batch = batch;
		isActive=true;
	}
	// getter and Setters

	public String getBatch() {
		return batch;
	}

	@Override
	public String toString() {
		return "StudentDTO [studentId=" + studentId + ", studentName=" + studentName + ", studentPass=" + studentPass
				+ ", studentEmail=" + studentEmail + ", batch=" + batch + ", isActive=" + isActive + "]";
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentPass() {
		return studentPass;
	}

	public void setStudentPass(String studentPass) {
		this.studentPass = studentPass;
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
		if (temp.getStudentEmail().equals(this.studentEmail))
			return true;
		return false;
	}

}
