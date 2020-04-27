package com.cg.feedback.dao;

import com.cg.feedback.exceptions.CustomException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.StudentDTO;

public class FeedbackDAOImpl implements FeedbackDAO {
	private static StaticDAO dao = new StaticDAO();

	@Override
	public FeedbackDTO giveFeedback(FeedbackDTO feedbackSet) throws CustomException {
		if (dao.getFeedback().values().contains(feedbackSet)) {
			throw new CustomException("Feedback has already been given by the Student with ID = "
					+ feedbackSet.getStudentId() + " for the Program with ID = " + feedbackSet.getProgramId());
		}
		dao.getFeedback().put(feedbackSet.getFeedbackId(), feedbackSet);
		return feedbackSet;
	}

	@Override
	public List<FeedbackDTO> viewFeedbackByProgram(String programId) throws CustomException {
		return dao.getFeedback().values().stream().filter(temp -> temp.getProgramId().equals(programId))
				.collect(Collectors.toList());
	}

	@Override
	public List<FeedbackDTO> viewFeedbackByTrainer(String trainerId) throws CustomException {
		return dao.getFeedback().values().stream().filter(temp -> temp.getTrainerId().equals(trainerId))
				.collect(Collectors.toList());
	}

	@Override
	public List<StudentDTO> viewFeedbackDefaultersByProgram(String programId) throws CustomException {
		List<String> courses = new ArrayList<>();
		for (List<String> e : dao.getListOfProgramInCourse().values()) {
			long days = ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.parse(e.get(3)));
			if (e.get(1).equals(programId) && days<=0 && days>=-30 ) {
				courses.add(e.get(0));
				break;
			}
		}
		if (courses.size()==0)
			throw new CustomException("Program not ended in any course in recent 30 days!");
		
		List<String> batches = new ArrayList<>();
		for (Map.Entry<String,String> e : dao.getBatchOfCourse().entrySet()) {
			if (courses.contains(e.getValue())) {
				batches.add(e.getKey());
				break;
			}
		}
		if (batches.size()==0)
			throw new CustomException("Program not ended in any course in recent 30 days!");
		
		List<StudentDTO> studentDTOs = dao.getStudents().values().stream().filter(temp -> batches.contains(temp.getBatch())).collect(Collectors.toList());
		List<String> students = studentDTOs.stream().map(temp->temp.getStudentId()).collect(Collectors.toList());
		
		if(students.size()==0) throw new CustomException("No Students have studied this program in recent 30 days!");
		
		List<String> studentFeedbackGiven = dao.getFeedback().values().stream().filter(temp -> temp.getProgramId().equals(programId) && students.contains(temp.getStudentId())).map(temp -> temp.getStudentId()).collect(Collectors.toList());
		
		return studentDTOs.stream().filter(temp -> !studentFeedbackGiven.contains(temp.getStudentId())).collect(Collectors.toList());
	}

	@Override
	public Map<String, List<StudentDTO>> viewFeedbackDefaultersByTrainer(String trainerId) throws CustomException {
		List<List<String>> trainers = dao.getListOfTrainerProgram().values().stream().filter(temp -> temp.get(0)==trainerId).collect(Collectors.toList());
		if(trainers.size()==0)throw new CustomException("Trainer not present!");
		
		Map<String,List<StudentDTO>> result = new HashMap<String,List<StudentDTO>>();
		trainers.stream().forEach(temp->{
			try {
				result.put(temp.get(1),viewFeedbackDefaultersByProgram(temp.get(1)));
			} catch (CustomException e) {
				result.put(temp.get(1), new ArrayList<StudentDTO>());
			}
		});
		
		return result;

	}

}