package com.cg.feedback.repository.dao;

import java.util.List;

import com.cg.feedback.repository.dto.TrainerDTO;
import com.cg.feedback.repository.exceptions.CustomException;

public interface TrainerDAO {
	boolean addTrainer(TrainerDTO trainer) throws CustomException;
	boolean removeTrainer(String trainerId) throws CustomException;
	boolean addTrainerSkill(String skill,String trainerId) throws CustomException;
	boolean removeTrainerSkill(String skillName,String trainerId) throws CustomException;
	
	boolean validateTrainer(String trainerId,String pass) throws CustomException;
	TrainerDTO getTrainer(String trainerId) throws CustomException;
	String getTrainerFromProgram(String batchId, String programsId);
	List<String> getTrainers() throws CustomException;
	String getProgramFromTrainer(String batchId, String trainerId);
	List<String> getAvailableTrainers(String batchId);
}