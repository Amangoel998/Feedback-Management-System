package com.cg.feedback.repository.dao;

import java.util.List;
import java.util.Map;

import com.cg.feedback.repository.dto.FeedbackDTO;
import com.cg.feedback.repository.dto.StudentDTO;
import com.cg.feedback.repository.exceptions.CustomException;

public interface FeedbackDAO {
	List<StudentDTO> viewFeedbackDefaultersByProgram(String programId) throws CustomException;
	Map<String, List<StudentDTO>> viewFeedbackDefaultersByTrainer(String trainerId) throws CustomException;
	
	FeedbackDTO giveFeedback(FeedbackDTO feedbackSet) throws CustomException;
	List<FeedbackDTO> viewFeedbackByProgram(String programId) throws CustomException;
	List<FeedbackDTO> viewFeedbackByTrainer(String trainerId) throws CustomException;
}
