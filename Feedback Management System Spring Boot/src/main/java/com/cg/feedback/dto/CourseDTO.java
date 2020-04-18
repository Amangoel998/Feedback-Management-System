package com.cg.feedback.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class CourseDTO {
	
	@Id
	@Column(name="courseid", updatable=false)
	private String courseId;
	
	@Column(name="coursename", updatable=false)
	private String courseName;

	@Column(name="isactive")
	private boolean isActive;
	
	//Constructor
	public CourseDTO(String courseId, String courseName, boolean isActive) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.isActive = isActive;
	}
	
	//Getter and Setters

	public CourseDTO() {
		super();
	}

	@Override
	public String toString() {
		return "CourseDTO [courseId=" + courseId + ", courseName=" + courseName + ", isActive=" + isActive + "]";
	}

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
	
}
