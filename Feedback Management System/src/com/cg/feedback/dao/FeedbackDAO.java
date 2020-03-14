package com.cg.feedback.dao;

import java.util.List;

import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.exceptions.CustomException;

public interface FeedbackDAO {
	List<StudentDTO> viewFeedbackDefaulters(String programId) throws CustomException;
	
	FeedbackDTO giveFeedback(FeedbackDTO feedbackSet) throws CustomException;
	List<FeedbackDTO> viewFeedbackByProgram(ProgramDTO program) throws CustomException;
	List<FeedbackDTO> viewFeedbackByTrainer(TrainerDTO trainer) throws CustomException;
}
