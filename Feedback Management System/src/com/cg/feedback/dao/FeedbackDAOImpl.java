package com.cg.feedback.dao;

import com.cg.feedback.exceptions.CustomException;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.cg.feedback.dto.CourseDTO;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.dto.QuestionsSetDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.dto.TrainerDTO;

public class FeedbackDAOImpl {
	/*
	private static StaticDAO dao = new StaticDAO();

	@Override
	public boolean giveFeedback(FeedbackDTO feedbackSet) throws CustomException {
		if (dao.getFeedback().values().contains(feedbackSet)) {
			throw new CustomException("Feedback has already been given by the Student with ID = "
					+ feedbackSet.getStudent().getStudentId() + " for the Program with ID = "
					+ feedbackSet.getProgram().getProgramId());
		}
		dao.getFeedback().put(feedbackSet.getFeedbackId(), feedbackSet);
		return true;
	}

	@Override
	public List<FeedbackDTO> viewFeedback(ProgramDTO program) throws CustomException {
		return dao.getFeedback().values().stream().filter(temp -> temp.getProgram().equals(program))
				.collect(Collectors.toList());
	}

	@Override
	public List<FeedbackDTO> viewFeedback(TrainerDTO trainer) throws CustomException {
		return dao.getFeedback().values().stream().filter(temp -> temp.getTrainer().equals(trainer))
				.collect(Collectors.toList());
	}

	static String batch = null;

	@Override
	public List<StudentDTO> viewFeedbackDefaulters(ProgramDTO program) throws CustomException {
		List<FeedbackDTO> feedback = viewFeedback(program);
		List<StudentDTO> students = new ArrayList<>();
		
		return feedback.stream().filter( el->{
			
		}).collect(Collectors.toList());
//		feedback.stream().forEach(temp -> students.add(temp.getStudent()));
		/*
		String course=null;
		for(List e : dao.getListOfProgramInCourse().values()){
			if(e.get(1).equals(program) && LocalDate.now().isAfter((LocalDate) e.get(2)) && LocalDate.now().isBefore((LocalDate) e.get(3))){
				course = (String) e.get(0);
				break;
			}
		}
		if(course==null)throw new CustomException("Course not present for this program or Course not started");
		
		for(Map.Entry e :dao.getBatchOfCourse().entrySet()){
			if(e.getValue().equals(course)){
				batch = (String) e.getKey();
				break;
			}
		}
		if(batch==null)throw new CustomException("Batch not made for the course");
		
		return dao.getStudents().values().stream().filter(temp -> !(students.contains(temp)) && temp.getBatch().equals(batch)).collect(Collectors.toList());
		
	}*/

}