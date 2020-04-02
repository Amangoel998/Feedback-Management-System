package com.cg.feedback.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="batchofcourse")
public class BatchCourseDTO {
	
	@Column(name="courseid")
	private String courseId;
	
	@Id
	@Column(name="batch")
	private String batch;

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public BatchCourseDTO(String courseId, String batch) {
		super();
		this.courseId = courseId;
		this.batch = batch;
	}

	public BatchCourseDTO() {
		super();
	}

	@Override
	public String toString() {
		return "BatchCourseDTO [courseId=" + courseId + ", batch=" + batch + "]";
	}
	
	
}
