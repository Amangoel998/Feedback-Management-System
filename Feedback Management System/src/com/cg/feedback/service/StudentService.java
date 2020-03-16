package com.cg.feedback.service;

import java.util.List;

import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.QuestionsSetDTO;
import com.cg.feedback.exceptions.CustomException;

public interface StudentService extends UserService{
	List<String> getProgramsEnrolled(String studentId) throws CustomException;
	FeedbackDTO giveFeedback(FeedbackDTO feedbackSet) throws CustomException;
}
