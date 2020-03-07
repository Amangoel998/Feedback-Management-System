package com.cg.feedback.dao;

import com.cg.feedback.exceptions.CustomException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.cg.feedback.dto.CourseDTO;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.dto.TrainerDTO;

public class FeedbackDAOImpl implements FeedbackDAO {
	private static StaticDAO dao = new StaticDAO();
	
	@Override
	public List<FeedbackDTO> viewFeedback(ProgramDAO program) throws CustomException {
		return dao.getFeedback().values().stream().filter(temp -> temp.getProgram().equals(program)).collect(Collectors.toList());
	}

	@Override
	public List<FeedbackDTO> viewFeedback(TrainerDTO trainer) throws CustomException {
		return dao.getFeedback().values().stream().filter(temp -> temp.getTrainer().equals(trainer)).collect(Collectors.toList());
	}
	
	static String batch=null;
	@Override
	public List<StudentDTO> viewFeedbackDefaulters(ProgramDAO program) throws CustomException {
		List<FeedbackDTO> feedback = viewFeedback(program);
//		List<StudentDTO> students = dao.getStudents().values().stream().filter(student -> student.getCourses().contains(program)).collect(Collectors.toList());
//		return students.stream().filter(student -> {
//			if(feedback.stream().filter(e -> e.getStudent().equals(student)).count()==0)return true;
//			return false;
//		}).collect(Collectors.toList());
		List<StudentDTO> students = new ArrayList<>();
		feedback.stream().forEach(temp -> students.add(temp.getStudent()));
		String course=null;
		for(List e : dao.getListOfProgramInCourse().values()){
			if(e.get(1).equals(program)){
				course = (String) e.get(0);
				break;
			}
		}
		if(course==null)throw new CustomException("Course not present for this program");
		for(Map.Entry e :dao.getBatchOfCourse().entrySet()){
			if(e.getValue().equals(course)){
				batch = (String) e.getKey();
				break;
			}
		}
		dao.getStudents().values().stream().filter(temp -> students.contains(temp) && temp.getBatch().equals(batch));
		return null;
	}
	
}