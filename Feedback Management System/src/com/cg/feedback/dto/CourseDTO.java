package com.cg.feedback.dto;

import java.util.ArrayList;

public class CourseDTO {
	private boolean isActive;
	private String courseId;
	private String courseName;
	private ArrayList<ProgramDTO> programs;
	
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

	public ArrayList<ProgramDTO> getPrograms() {
		return programs;
	}

	public void setPrograms(ArrayList<ProgramDTO> programs) {
		this.programs = programs;
	}
	
	
}
