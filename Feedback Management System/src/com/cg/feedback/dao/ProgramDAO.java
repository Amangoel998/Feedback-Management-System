package com.cg.feedback.dao;

import com.cg.feedback.exceptions.CustomException;

public interface ProgramDAO {
	void addTrainingProgram()  throws CustomException;
	void removeTrainingProgram()  throws CustomException;
}
