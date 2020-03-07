package com.cg.feedback.dao;

import com.cg.feedback.dto.SkillDTO;
import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.exceptions.CustomException;

public interface TrainerDAO {
	boolean addTrainer(TrainerDTO trainer) throws CustomException;
	boolean removeTrainer(String trainerId) throws CustomException;
	boolean addTrainerSkill(SkillDTO skill) throws CustomException;
	boolean removeTrainerSkill(String skillid) throws CustomException;
}
