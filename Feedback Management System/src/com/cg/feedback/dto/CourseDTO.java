package com.cg.feedback.dto;

import java.util.ArrayList;

public class CourseDTO {
	private boolean isActive;
	private String courseId;
	private String courseName;
	private ArrayList<String> programs;
	
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

	public ArrayList<String> getPrograms() {
		return programs;
	}

	public void setPrograms(ArrayList<String> programs) {
		this.programs = programs;
	}

	@Override
	public boolean equals(Object obj) {
		CourseDTO temp = (CourseDTO) obj;
		if(temp.getCourseName().equals(this.courseName))return true;
		return false;
	}
	
}
