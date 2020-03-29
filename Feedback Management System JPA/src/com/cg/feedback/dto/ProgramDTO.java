package com.cg.feedback.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="programs")
public class ProgramDTO {

	@Id
	@Column(name="programid")
	private String programId;
	
	@Column(name="programname")
	private String programName;
	
	@Column(name="isactive")
	private boolean isActive;

	// Constructor
	public ProgramDTO(String programId, String programName, boolean isActive) {
		super();
		this.programName = programName;
		this.programId = programId;
		this.isActive=isActive;
	}

	@Override
	public String toString() {
		return "ProgramDTO [programId=" + programId + ", programName=" + programName + ", isActive=" + isActive + "]";
	}

	// Getters and Setters
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	@Override
	public boolean equals(Object obj) {
		ProgramDTO temp = (ProgramDTO) obj;
		if (temp.getProgramName().equals(this.programName))
			return true;
		return false;
	}

}
