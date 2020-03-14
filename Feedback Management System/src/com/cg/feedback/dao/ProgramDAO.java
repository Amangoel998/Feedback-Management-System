package com.cg.feedback.dao;

import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.exceptions.CustomException;

public interface ProgramDAO {
	boolean addTrainingProgram(ProgramDTO program)  throws CustomException;
	boolean removeTrainingProgram(String programId)  throws CustomException;

	ProgramDTO getProgram(String programId) throws CustomException;
	
}
