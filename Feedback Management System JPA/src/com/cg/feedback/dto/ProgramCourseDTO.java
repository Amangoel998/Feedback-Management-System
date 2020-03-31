package com.cg.feedback.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="listofprogramincourse")
public class ProgramCourseDTO {
	
	@Id
	@Column(name="courseid", updatable=false)
	private String courseId;
	
	@Id
	@Column(name="programId", updatable=false)
	private String programId;
	
	@Column(name="startdate", updatable=false)
	private String startdate;
	
	@Column(name="enddate", updatable=false)
	private String enddate;

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	@Override
	public String toString() {
		return "ProgramCourseDTO [courseId=" + courseId + ", programId=" + programId + ", startdate=" + startdate
				+ ", enddate=" + enddate + "]";
	}

	public ProgramCourseDTO(String courseId, String programId, String startdate, String enddate) {
		super();
		this.courseId = courseId;
		this.programId = programId;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public ProgramCourseDTO() {
		super();
	}
	
	
	
}
