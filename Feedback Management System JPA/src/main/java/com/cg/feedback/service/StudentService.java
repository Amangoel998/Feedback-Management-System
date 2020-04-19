package com.cg.feedback.service;

import java.util.List;
import java.util.Map;

import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.exceptions.CustomException;

public interface StudentService extends UserService{
	FeedbackDTO giveFeedback(FeedbackDTO feedbackSet) throws CustomException;
	Map<String, FeedbackDTO> availableFeedbacks() throws CustomException;
}
