package com.cg.feedback.service;

import java.util.List;

import com.cg.feedback.dto.QuestionsSetDTO;
import com.cg.feedback.exceptions.CustomException;

public interface StudentService extends UserService{
	List<String> getProgramsEnrolled() throws CustomException;
	boolean giveFeedback(QuestionsSetDTO questionSet, String programID) throws CustomException;
}
