package com.cg.feedback.dao;

import com.cg.feedback.exceptions.CustomException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.StudentDTO;

@Repository
public class FeedbackDAOImpl implements FeedbackDAO{
	
	@PersistenceContext
	private EntityManager manager;
	private static StaticDAO dao = new StaticDAO();

	@Override
	public FeedbackDTO giveFeedback(FeedbackDTO feedbackSet) throws CustomException {
		FeedbackDTO temp = manager.find(FeedbackDTO.class, feedbackSet.getFeedbackId());
		if (temp!=null) {
			throw new CustomException("Feedback has already been given by the Student with ID = "
					+ feedbackSet.getStudentId() + " for the Program with ID = "
					+ feedbackSet.getProgramId());
		}
		manager.persist(feedbackSet);
		return feedbackSet;
	}

	@Override
	public List<FeedbackDTO> viewFeedbackByProgram(String programId) throws CustomException {
		return manager.createQuery("from FeedbackDTO where programid='"+programId+"'",FeedbackDTO.class).getResultList();
	}

	@Override
	public List<FeedbackDTO> viewFeedbackByTrainer(String trainerId) throws CustomException {
		return manager.createQuery("from FeedbackDTO where trainerid='"+trainerId+"'",FeedbackDTO.class).getResultList();
	}

	static String batch = null;

	@Override
	public List<StudentDTO> viewFeedbackDefaultersByProgram(String programId) throws CustomException {
		List<StudentDTO> students = new ArrayList<>();
		batch = null;
		String course=null;
		for(List e : dao.getListOfProgramInCourse().values()){
			if(e.get(1).equals(programId) && LocalDate.now().isAfter((LocalDate) e.get(2)) && LocalDate.now().isBefore((LocalDate) e.get(3))){
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
		
	}
	@Override
	public List<StudentDTO> viewFeedbackDefaultersByTrainer(String trainerId) throws CustomException {
		List<FeedbackDTO> feedback = viewFeedbackByTrainer(trainerId);
		List<StudentDTO> students = new ArrayList<>();
		
		String course=null;
		for(List e : dao.getListOfProgramInCourse().values()){
			if(e.get(1).equals(trainerId) && LocalDate.now().isAfter((LocalDate) e.get(2)) && LocalDate.now().isBefore((LocalDate) e.get(3))){
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
		
	}

}