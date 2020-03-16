package com.cg.feedback.dao;

import java.util.List;

import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.exceptions.CustomException;

public interface FeedbackDAO {
	List<StudentDTO> viewFeedbackDefaultersByProgram(String programId) throws CustomException;
	List<StudentDTO> viewFeedbackDefaultersByTrainer(String trainerId) throws CustomException;
	
	FeedbackDTO giveFeedback(FeedbackDTO feedbackSet) throws CustomException;
	List<FeedbackDTO> viewFeedbackByProgram(String programId) throws CustomException;
	List<FeedbackDTO> viewFeedbackByTrainer(String trainerId) throws CustomException;
}
