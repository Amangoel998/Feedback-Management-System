package com.cg.feedback.service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.cg.feedback.dao.FeedbackDAO;
import com.cg.feedback.dao.FeedbackDAOImpl;
import com.cg.feedback.dao.StudentDAO;
import com.cg.feedback.dao.StudentDAOImpl;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.exceptions.CustomException;

@Service
@Scope("singleton")
public class StudentServiceImpl implements StudentService {
		private static FeedbackDAO fdbDao = new FeedbackDAOImpl();
		private static StudentDAO stdDao = new StudentDAOImpl();

		@Override
		public StudentDTO login(String id, String pass) throws CustomException {
			StudentDTO student = stdDao.validateStudent(id, pass);
			return student;
		}
		public List<FeedbackDTO> availableFeedbacks(String studentId) throws CustomException{
			return stdDao.getAvailableFeedbacks(studentId);
		}

		@Override
		public FeedbackDTO giveFeedback(FeedbackDTO feedbackSet) throws CustomException {
			return fdbDao.giveFeedback(feedbackSet);
		}
}
