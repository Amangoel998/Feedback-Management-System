package com.cg.feedback.dto;

public class ProgramDTO {
	
	private String programName;
	private String programId;
	private boolean isActive;
	
	//Constructor
	public ProgramDTO(String programName, String programId) {
		super();
		this.programName = programName;
		this.programId = programId;
	}
	
	//Getters and Setters
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
	

}
