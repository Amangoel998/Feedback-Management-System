package com.cg.feedback.dao;

import com.cg.feedback.exceptions.CustomException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cg.feedback.dto.CourseDTO;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.dto.TrainerDTO;

public class FeedbackDAOImpl implements FeedbackDAO {
	private static StaticDAO dao = new StaticDAO();
	
	@Override
	public ArrayList<FeedbackDTO> viewFeedback(ProgramDAO program) throws CustomException {
		return dao.getFeedback(program);
	}

	@Override
	public ArrayList<FeedbackDTO> viewFeedback(TrainerDTO trainer) throws CustomException {
		return dao.getFeedback(trainer);
	}

	@Override
	public List<StudentDTO> viewFeedbackDefaulters(ProgramDAO program) throws CustomException {
		ArrayList<FeedbackDTO> feedback = viewFeedback(program);
//		List<StudentDTO> students = dao.getStudents().values().stream().filter(student -> student.getCourses().contains(program)).collect(Collectors.toList());
//		return students.stream().filter(student -> {
//			if(feedback.stream().filter(e -> e.getStudent().equals(student)).count()==0)return true;
//			return false;
//		}).collect(Collectors.toList());
		return null;
	}
	
}
