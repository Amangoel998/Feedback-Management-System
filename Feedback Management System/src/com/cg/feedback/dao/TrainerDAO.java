package com.cg.feedback.dao;

import com.cg.feedback.dto.SkillDTO;
import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.exceptions.CustomException;

public interface TrainerDAO {
	boolean addTrainer(TrainerDTO trainer) throws CustomException;
	boolean removeTrainer(String trainerId) throws CustomException;
	boolean addTrainerSkill(String skill,String trainerId) throws CustomException;
	boolean removeTrainerSkill(String skillName,String trainerId) throws CustomException;
	
	boolean validateTrainer(String trainerId,String pass) throws CustomException;
	TrainerDTO getTrainer(String trainerId) throws CustomException;
	String getTrainerFromProgram(String batchId, String programsId);
}