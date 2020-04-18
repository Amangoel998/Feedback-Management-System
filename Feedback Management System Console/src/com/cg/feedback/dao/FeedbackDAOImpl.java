package com.cg.feedback.dao;

import com.cg.feedback.exceptions.CustomException;

import java.time.LocalDate;
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

	static String batch = null;

	@Override
	public List<StudentDTO> viewFeedbackDefaultersByProgram(String programId) throws CustomException {
		List<StudentDTO> students = new ArrayList<>();
		batch = null;
		String course = null;
		for (List e : dao.getListOfProgramInCourse().values()) {
			if (e.get(1).equals(programId) && LocalDate.now().isAfter((LocalDate) e.get(2))
					&& LocalDate.now().isBefore((LocalDate) e.get(3))) {
				course = (String) e.get(0);
				break;
			}
		}
		if (course == null)
			throw new CustomException("Course not present for this program or Course not started");

		for (Map.Entry<String,String> e : dao.getBatchOfCourse().entrySet()) {
			if (e.getValue().equals(course)) {
				batch = (String) e.getKey();
				break;
			}
		}
		if (batch == null)
			throw new CustomException("Batch not made for the course");

		return dao.getStudents().values().stream()
				.filter(temp -> !(students.contains(temp)) && temp.getBatch().equals(batch))
				.collect(Collectors.toList());

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