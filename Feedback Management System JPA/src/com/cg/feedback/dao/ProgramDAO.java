package com.cg.feedback.dao;

import java.util.List;

import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.exceptions.CustomException;

public interface ProgramDAO {
	boolean addTrainingProgram(ProgramDTO program)  throws CustomException;
	boolean removeTrainingProgram(String programId)  throws CustomException;
	ProgramDTO getProgram(String programId) throws CustomException;
	List<String> getPrograms() throws CustomException;
	List<String> availablePrograms(String batch);
	
}
