package com.cg.feedback.repository.service;

import java.util.List;

import com.cg.feedback.repository.dto.FeedbackDTO;
import com.cg.feedback.repository.exceptions.CustomException;

public interface StudentService extends UserService{
	List<String> getProgramsEnrolled() throws CustomException;
	FeedbackDTO giveFeedback(FeedbackDTO feedbackSet) throws CustomException;
}
