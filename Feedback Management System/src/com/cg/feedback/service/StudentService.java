package com.cg.feedback.service;

import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.QuestionsSetDTO;
import com.cg.feedback.exceptions.CustomException;

public interface StudentService extends UserService{
	boolean giveFeedback(FeedbackDTO feedbackSet) throws CustomException;
}
