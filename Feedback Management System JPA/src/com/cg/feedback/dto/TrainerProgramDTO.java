package com.cg.feedback.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="listoftrainerprogram")
public class TrainerProgramDTO {
	
	@Id
	@Column(name="trainerid")
	private String trainerId;
	
	@Id
	@Column(name="programid")
	private String programId;
	
	@Column(name="batch")
	private String batch;

	public String getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	@Override
	public String toString() {
		return "TrainerProgramDTO [trainerId=" + trainerId + ", programId=" + programId + ", batch=" + batch + "]";
	}

	public TrainerProgramDTO(String trainerId, String programId, String batch) {
		super();
		this.trainerId = trainerId;
		this.programId = programId;
		this.batch = batch;
	}

	public TrainerProgramDTO() {
		super();
	}
	
	
}
