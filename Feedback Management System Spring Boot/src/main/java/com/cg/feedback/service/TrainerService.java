package com.cg.feedback.service;

import java.util.List;
import java.util.Map;

import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.exceptions.CustomException;

public interface TrainerService{
	TrainerDTO login(String id, String pass) throws CustomException;
	List<FeedbackDTO> showFeedBack(String trainerId) throws CustomException;
	Map<String, List<StudentDTO>> showDefaulters(String trainerId) throws CustomException;
}