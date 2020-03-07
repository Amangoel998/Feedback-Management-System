package com.cg.feedback.service;

import com.cg.feedback.dao.FeedbackDAO;
import com.cg.feedback.dao.FeedbackDAOImpl;
import com.cg.feedback.dao.StudentDAO;
import com.cg.feedback.dao.StudentDAOImpl;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.QuestionsSetDTO;
import com.cg.feedback.exceptions.CustomException;

public class StudentServiceImpl implements StudentService {

	private static FeedbackDAO fdb = new FeedbackDAOImpl();
	@Override
	public boolean login(String id, String pass) throws CustomException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logout() throws CustomException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean giveFeedback(FeedbackDTO feedbackSet) throws CustomException {
		return fdb.giveFeedback(feedbackSet);
	}

}
