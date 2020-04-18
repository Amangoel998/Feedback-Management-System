package com.cg.feedback.service;

import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.exceptions.CustomException;

public interface StudentService{
	StudentDTO login(String Id, String pass) throws CustomException;
	FeedbackDTO giveFeedback(FeedbackDTO feedbackSet) throws CustomException;
}
