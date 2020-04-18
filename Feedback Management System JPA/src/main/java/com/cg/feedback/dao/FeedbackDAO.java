package com.cg.feedback.dao;

import java.util.List;
import java.util.Map;

import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.ReportDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.exceptions.CustomException;

public interface FeedbackDAO {
	List<StudentDTO> viewFeedbackDefaultersByProgram(String programId) throws CustomException;
	Map<String, List<StudentDTO>> viewFeedbackDefaultersByTrainer(String trainerId) throws CustomException;
	
	FeedbackDTO giveFeedback(FeedbackDTO feedbackSet) throws CustomException;
	ReportDTO viewFeedbackByProgram(String programId) throws CustomException;
	ReportDTO viewFeedbackByTrainer(String trainerId) throws CustomException;
}
