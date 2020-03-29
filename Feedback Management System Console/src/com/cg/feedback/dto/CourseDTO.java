package com.cg.feedback.dto;


public class CourseDTO {
	private boolean isActive;
	private String courseId;
	private String courseName;
	
	//Constructor
	public CourseDTO(String courseId, String courseName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
	}
	
	//Getter and Setters
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public boolean equals(Object obj) {
		CourseDTO temp = (CourseDTO) obj;
		if(temp.getCourseName().equals(this.courseName))return true;
		return false;
	}
	
}
