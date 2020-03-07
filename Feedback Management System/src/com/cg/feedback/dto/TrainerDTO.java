package com.cg.feedback.dto;

import java.util.ArrayList;

public class TrainerDTO {
	
	private String trainerId;
	private String programId;
	private String trainerName;
	private ArrayList<String> skills;
	private String trainerPass;
	private String trainerEmail;
	private boolean isActive;
	
	
	//constructor
	public TrainerDTO(String trainerId, String trainerName, String trainerPass, String trainerEmail) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.trainerPass = trainerPass;
		this.trainerEmail = trainerEmail;
	}
	
	//Getters and Setters
	
	public String getProgramId() {
		return programId;
	}
	public void setProgramId(String programId) {
		this.programId = programId;
	}
	
	public String getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	
	public String getTrainerPass() {
		return trainerPass;
	}
	public void setTrainerPass(String trainerPass) {
		this.trainerPass = trainerPass;
	}
	public String getTrainerEmail() {
		return trainerEmail;
	}
	public void setTrainerEmail(String trainerEmail) {
		this.trainerEmail = trainerEmail;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public ArrayList<String> getSkills() {
		return skills;
	}
	public void setSkills(ArrayList<String> skills) {
		this.skills = skills;
	}
}
