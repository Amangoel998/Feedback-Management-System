package com.cg.feedback.repository.service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.cg.feedback.repository.dao.FeedbackDAO;
import com.cg.feedback.repository.dao.FeedbackDAOImpl;
import com.cg.feedback.repository.dao.StudentDAO;
import com.cg.feedback.repository.dao.StudentDAOImpl;
import com.cg.feedback.repository.dto.FeedbackDTO;
import com.cg.feedback.repository.dto.StudentDTO;
import com.cg.feedback.repository.exceptions.CustomException;

@Service
@Scope("singleton")
public class StudentServiceImpl implements StudentService {
		private static StudentDTO student = null;

		private static FeedbackDAO fdbDao = new FeedbackDAOImpl();
		private static StudentDAO stdDao = new StudentDAOImpl();

		@Override
		public boolean login(String id, String pass) throws CustomException {
			if(student != null)
				return true;
			else {
				if(stdDao.validateStudent(id, pass)){
					student = stdDao.getStudent(id);
					return true;
				}
				else{
					student = null;
					return false;
				}
			}
		}

		public boolean logout() throws CustomException {
			if (student == null)
				return true;
			else {
				student = null;
				return true;
			}
		}

		public List<FeedbackDTO> availableFeedbacks() throws CustomException{
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
