package com.cg.feedback.service;

import com.cg.feedback.dto.QuestionsSetDTO;
import com.cg.feedback.exceptions.CustomException;

public interface StudentService extends UserService{
	void giveFeedback(QuestionsSetDTO feedbackSet) throws CustomException;
}
