package com.cg.feedback.dto;

import java.util.ArrayList;

public class TrainerDTO {
	
	private String trainerId;
	private String programId;
	private String trainerName;
	private ArrayList<SkillDTO> skills;
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
	public ArrayList<SkillDTO> getSkill() {
		return skills;
	}
	public void setSkill(ArrayList<SkillDTO> skill) {
		this.skills = skill;
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
	public ArrayList<SkillDTO> getSkills() {
		return skills;
	}
	public void setSkills(ArrayList<SkillDTO> skills) {
		this.skills = skills;
	}
	@Override
	public boolean equals(Object obj) {
		TrainerDTO temp = (TrainerDTO) obj;
		if(temp.getTrainerEmail().equals(this.trainerEmail))
			return true;
		return false;
	}
	
	
}
