package com.cg.feedback.service;

import com.cg.feedback.dto.QuestionsSetDTO;
import com.cg.feedback.exceptions.CustomException;

public interface StudentService{
	boolean login(String id, String pass) throws CustomException;
	void giveFeedback(QuestionsSetDTO feedbackSet) throws CustomException;
	boolean logout() throws CustomException;
}
