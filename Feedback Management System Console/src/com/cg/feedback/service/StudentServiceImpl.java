package com.cg.feedback.service;

import java.util.List;

import com.cg.feedback.dao.FeedbackDAO;
import com.cg.feedback.dao.FeedbackDAOImpl;
import com.cg.feedback.dao.StudentDAO;
import com.cg.feedback.dao.StudentDAOImpl;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.exceptions.CustomException;

public class StudentServiceImpl implements StudentService {
	private static StudentDTO student=null;
	
	private static FeedbackDAO fdbDao = new FeedbackDAOImpl();
	private static StudentDAO stdDao = new StudentDAOImpl();

	@Override
	public boolean login(String id, String pass) throws CustomException {
		if(student != null)
			return true;
		else {
			if(stdDao.validateStudent(id, pass)){
				student = stdDao.getStudent(id);
				if(student.getStudentPass().equals(pass))
					return true;
				else{
					student = null;
					return false;
				}
			}
			return logout();
		}
	}

	@Override
	public boolean logout() throws CustomException {
		if(student == null)return true;
		else {
			student = null;
			return true;
		}
	}
	public List<FeedbackDTO> availableFeedbacks(){
		return stdDao.getAvailableFeedbacks(student.getStudentId());
		
	}
	@Override
	public FeedbackDTO giveFeedback(FeedbackDTO feedbackSet) throws CustomException {
		return fdbDao.giveFeedback(feedbackSet);
	}

	@Override
	public List<String> getProgramsEnrolled() throws CustomException {
		return stdDao.getAvailablePrograms(student.getStudentId());
	}
}
