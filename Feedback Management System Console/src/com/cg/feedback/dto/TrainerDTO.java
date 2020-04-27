package com.cg.feedback.dto;

import java.util.ArrayList;
import java.util.List;

public class TrainerDTO {

	private String trainerId;
	private String trainerName;
	private List<String> skills;
	private String trainerPass;
	private String trainerEmail;
	private boolean isActive;

	// constructor
	public TrainerDTO(String trainerId, String trainerName, String trainerPass, String trainerEmail) {
		super();
		skills = new ArrayList<String>();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.trainerPass = trainerPass;
		this.trainerEmail = trainerEmail;
		isActive=true;
	}

	// Getters and Setters
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

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public void addSkill(String s) {
		if (this.skills == null)
			this.skills = new ArrayList<>();
		this.skills.add(s);
	}

	@Override
	public String toString() {
		return "TrainerDTO [trainerId=" + trainerId + ", trainerName=" + trainerName + ", skills=" + skills
				+ ", trainerPass=" + trainerPass + ", trainerEmail=" + trainerEmail + ", isActive=" + isActive + "]";
	}

	@Override
	public boolean equals(Object obj) {
		TrainerDTO temp = (TrainerDTO) obj;
		if (temp.getTrainerEmail().equals(this.trainerEmail))
			return true;
		return false;
	}

}
