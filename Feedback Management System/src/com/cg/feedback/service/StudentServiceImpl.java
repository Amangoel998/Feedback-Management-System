package com.cg.feedback.service;

import java.util.List;

import com.cg.feedback.dao.FeedbackDAO;
import com.cg.feedback.dao.FeedbackDAOImpl;
import com.cg.feedback.dao.StudentDAO;
import com.cg.feedback.dao.StudentDAOImpl;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.QuestionsSetDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.exceptions.CustomException;

public class StudentServiceImpl implements UserService, StudentService{
	private static StudentDTO student=null;
	
	private static FeedbackDAO fdb = new FeedbackDAOImpl();
	private static StudentDAO std = new StudentDAOImpl();
	@Override
	public boolean login(String id, String pass) throws CustomException {
		if(student != null)
			return false;
		else {
			if(std.validateStudent(id, pass)){
				student = std.getStudent(id);
				return true;
			}
			return logout();
		}
	}

	@Override
	public boolean logout() throws CustomException {
		if(student == null)return true;
		else {
			student = null;
			return false;
		}
	}
	public static List<FeedbackDTO> availableFeedbacks(String studentId){
		return std.getAvailableFeedbacks(studentId);
		
	}
	@Override
	public FeedbackDTO giveFeedback(FeedbackDTO feedbackSet) throws CustomException {
		return fdb.giveFeedback(feedbackSet);
	}

	@Override
	public List<String> getProgramsEnrolled(String studentId) throws CustomException {
		return std.getAvailablePrograms(studentId);
	}
}
