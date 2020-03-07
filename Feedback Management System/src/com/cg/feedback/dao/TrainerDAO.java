package com.cg.feedback.dao;

import com.cg.feedback.exceptions.CustomException;

public interface TrainerDAO {
	void addTrainer() throws CustomException;
	void removeTrainer() throws CustomException;
	void maintainTrainerSkillset() throws CustomException;
	void updateTrainingProgram() throws CustomException;
}
