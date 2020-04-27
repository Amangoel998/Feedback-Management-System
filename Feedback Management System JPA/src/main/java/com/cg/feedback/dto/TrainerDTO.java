package com.cg.feedback.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trainers")
public class TrainerDTO {

	@Id
	@Column(name="trainerid", updatable=false)
	private String trainerId;
	
	@Column(name="trainername", updatable=false)
	private String trainerName;
	
	@Column(name="skills")
	private String skills;
	
	@Column(name="traineremail")
	private String trainerEmail;

	// constructor
	public TrainerDTO(String trainerId, String trainerName, String skills, String trainerEmail) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.skills=skills;
		this.trainerEmail = trainerEmail;
	}

	public TrainerDTO() {
		super();
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

	public String getTrainerEmail() {
		return trainerEmail;
	}

	public void setTrainerEmail(String trainerEmail) {
		this.trainerEmail = trainerEmail;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	@Override
	public boolean equals(Object obj) {
		TrainerDTO temp = (TrainerDTO) obj;
		if (temp.getTrainerEmail().equals(this.trainerEmail))
			return true;
		return false;
	}

}
