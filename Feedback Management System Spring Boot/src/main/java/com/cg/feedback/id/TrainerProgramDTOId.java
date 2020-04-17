package com.cg.feedback.id;

import java.io.Serializable;

public class TrainerProgramDTOId implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String batch, programId;

	public TrainerProgramDTOId(String trainerId, String programId) {
		super();
		this.batch = trainerId;
		this.programId = programId;
	}

	public TrainerProgramDTOId() {
		super();
	}

	@Override
	public boolean equals(Object arg0) {
		return super.equals(arg0);
	}

	@Override
	public int hashCode() {
		return Integer.parseInt(batch.substring(3)+programId.substring(3));
	}
	
}
