package com.cg.feedback.dao;

import com.cg.feedback.dto.QuestionsSetDTO;
import com.cg.feedback.exceptions.CustomException;

public interface StudentDAO {
	void addStudents() throws CustomException;
	void removeStudents() throws CustomException;
	void giveFeedback(QuestionsSetDTO feedbackSet) throws CustomException;
}
