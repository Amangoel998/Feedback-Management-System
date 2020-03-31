package com.cg.feedback.dao;

import com.cg.feedback.exceptions.CustomException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.feedback.dto.BatchCourseDTO;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.ProgramCourseDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.dto.TrainerProgramDTO;

@Repository
public class FeedbackDAOImpl implements FeedbackDAO{
	
	@PersistenceContext
	private EntityManager manager;

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

	@Transactional
	public List<FeedbackDTO> viewFeedbackByProgram(String programId) throws CustomException {
		System.out.println("1");
		return manager.createQuery("from FeedbackDTO where programid='"+programId+"'",FeedbackDTO.class).getResultList();
	}

	@Override
	public List<FeedbackDTO> viewFeedbackByTrainer(String trainerId) throws CustomException {
		return manager.createQuery("from FeedbackDTO where trainerid='"+trainerId+"'",FeedbackDTO.class).getResultList();
	}

	static String batch = null;

	@Override
	public List<StudentDTO> viewFeedbackDefaultersByProgram(String programId) throws CustomException {
		List<String> course = new ArrayList<>();
		List<ProgramCourseDTO> courses = manager.createQuery("from ProgramCourseDTO where programid='"+programId+"'",ProgramCourseDTO.class).getResultList();
		for(ProgramCourseDTO e : courses){
			if(LocalDate.now().isAfter(LocalDate.parse(e.getStartdate())) && LocalDate.now().isBefore(LocalDate.parse(e.getEnddate()))){
				course.add(e.getCourseId());
			}
		}
		if(course.size()==0)throw new CustomException("Course not present for this program or Course not started");
		
		Query query1 = manager.createQuery("SELECT batch from BatchCourseDTO where course IN :param",String.class);
		query1.setParameter("param", course);
		List<String> batches = query1.getResultList();
		
		if(batches.size()==0)throw new CustomException("Batch not made for the course");
		
		Query query2 = manager.createQuery("from StudentDTO where batch IN :param",StudentDTO.class);
		query2.setParameter("param", batches);
		List<StudentDTO> studentDTOs = query2.getResultList();
		List<String> students = studentDTOs.stream().map(temp->temp.getStudentId()).collect(Collectors.toList());
		
		if(students.size()==0) throw new CustomException("No Students in these batches!");
		
		Query query3 = manager.createQuery("from FeedbackDTO where programid='"+programId+"' studentid IN :param",FeedbackDTO.class);
		query3.setParameter("param", students);
		List<FeedbackDTO> feedbacksGiven = query3.getResultList();
		List<String> studentFeedbackGiven = feedbacksGiven.stream().map(temp -> temp.getStudentId()).collect(Collectors.toList());
		
		return studentDTOs.stream().filter(temp -> !studentFeedbackGiven.contains(temp.getStudentId())).collect(Collectors.toList());
	}
	@Override
	public Map<String,List<StudentDTO>> viewFeedbackDefaultersByTrainer(String trainerId) throws CustomException {
		List<TrainerProgramDTO> trainers = manager.createQuery("from TrainerProgramDTO where trainerid='"+trainerId+"'",TrainerProgramDTO.class).getResultList();
		if(trainers.size()==0)throw new CustomException("Trainer not present!");
		
		Map<String,List<StudentDTO>> result = new HashMap<String,List<StudentDTO>>();
		trainers.stream().forEach(temp->result.put(temp.getProgramId(),viewFeedbackDefaultersByProgram(temp.getProgramId())));
		
		return result;
	}

}