package com.cg.feedback.id;

import java.io.Serializable;

public class ProgramCourseDTOId implements Serializable{
	private String programId, courseId;

	public ProgramCourseDTOId(String programId, String courseId) {
		super();
		this.programId = programId;
		this.courseId = courseId;
	}

	public ProgramCourseDTOId() {
		super();
	}

	@Override
	public boolean equals(Object arg0) {
		return super.equals(arg0);
	}

	@Override
	public int hashCode() {
		return Integer.parseInt(programId.substring(3)+courseId.substring(3));
	}
	
}
