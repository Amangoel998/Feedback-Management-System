package com.cg.feedback.dao;

import com.cg.feedback.exceptions.CustomException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.cg.feedback.dto.BatchCourseDTO;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.ProgramCourseDTO;
import com.cg.feedback.dto.ReportDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.dto.TrainerProgramDTO;

public class FeedbackDAOImpl implements FeedbackDAO{

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Feedback Management System JPA");
	private EntityManager manager = emf.createEntityManager();

	@Override
	public FeedbackDTO giveFeedback(FeedbackDTO feedbackSet) throws CustomException {
		if(!manager.getTransaction().isActive())manager.getTransaction().begin();
		FeedbackDTO temp = manager.find(FeedbackDTO.class, feedbackSet.getFeedbackId());
		if (temp!=null) {
			throw new CustomException("Feedback has already been given by the Student with ID = "
					+ feedbackSet.getStudentId() + " for the Program with ID = "
					+ feedbackSet.getProgramId());
		}
		manager.persist(feedbackSet);
		manager.getTransaction().commit();
		return feedbackSet;
	}

	@Transactional
	public ReportDTO viewFeedbackByProgram(String programId) throws CustomException {
		return new ReportDTO(manager.createQuery("from FeedbackDTO where programid='"+programId+"'",FeedbackDTO.class).getResultList());
	}

	@Override
	public ReportDTO viewFeedbackByTrainer(String trainerId) throws CustomException {
		return new ReportDTO(manager.createQuery("from FeedbackDTO where trainerid='"+trainerId+"'",FeedbackDTO.class).getResultList());
	}

	static String batch = null;

	@Override
	public List<StudentDTO> viewFeedbackDefaultersByProgram(String programId) throws CustomException {
		List<String> course = new ArrayList<>();
		List<ProgramCourseDTO> courses = manager.createQuery("from ProgramCourseDTO where programid='"+programId+"'",ProgramCourseDTO.class).getResultList();
		for(ProgramCourseDTO e : courses){
			long days = ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.parse(e.getEnddate()));
			if(days<=0 && days>=-30){
				course.add(e.getCourseId());
			}
		}
		if(course.size()==0)throw new CustomException("Course not present for this program or Course not started");
		
		Query query1 = manager.createQuery("from BatchCourseDTO where courseid IN :param",BatchCourseDTO.class);
		query1.setParameter("param", course);
		List<String> batches = ((List<BatchCourseDTO>)query1.getResultList()).stream().map(temp->temp.getBatch()).collect(Collectors.toList());
		
		if(batches.size()==0)throw new CustomException("Batch not made for the course");
		
		Query query2 = manager.createQuery("from StudentDTO where batch IN :param",StudentDTO.class);
		query2.setParameter("param", batches);
		List<StudentDTO> studentDTOs = query2.getResultList();
		List<String> students = studentDTOs.stream().map(temp->temp.getStudentId()).collect(Collectors.toList());
		
		if(students.size()==0) throw new CustomException("No Students in these batches!");
		
		Query query3 = manager.createQuery("from FeedbackDTO where programid='"+programId+"' and studentid IN :param",FeedbackDTO.class);
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
		trainers.stream().forEach(temp->{
			try {
				result.put(temp.getProgramId(),viewFeedbackDefaultersByProgram(temp.getProgramId()));
			} catch (CustomException e) {
				result.put(temp.getProgramId(), new ArrayList<StudentDTO>());
			}
		});
		
		return result;
	}

}