package com.cg.feedback.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.feedback.dto.BatchCourseDTO;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.ProgramCourseDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.exceptions.CustomException;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	TrainerDAO trainerDAO;
	
	@Override
	public StudentDTO getStudent(String studentId) throws CustomException {
		
		StudentDTO student = manager.find(StudentDTO.class, studentId);
		if (student != null)
			return student;
		else
			throw new CustomException("Student with Id: " + studentId + " not present");
	}
	
	@Override
	public boolean addStudents(StudentDTO student) throws CustomException {

		StudentDTO temp = manager.find(StudentDTO.class, student.getStudentId());
		if(temp!=null) {
			if(temp.isActive())
				throw new CustomException("Student Exception : Student with Id: "+student.getStudentId()+" already exists.");
			else{
				temp.setActive(true);
				throw new CustomException("Student Exception : Student with Id: "+student.getStudentId()+" already exists and status has been set to active.");
			}
		}
		else{
			manager.persist(student);
			return true;
		}
	}
	@Override
	public List<String> getAvailablePrograms(String course) throws CustomException {
		Query query2 = manager.createQuery("from ProgramCourseDTO where courseid='"+course+"'",ProgramCourseDTO.class);
		List<ProgramCourseDTO> res2 = query2.getResultList();
		return res2.stream().filter(temp -> {
			if(LocalDate.parse(temp.getEnddate()).isBefore(LocalDate.now()))
				return true;
			return false;
		}).map(temp -> temp.getProgramId()).collect(Collectors.toList());
	}
	
	@Override
	public List<FeedbackDTO> getAvailableFeedbacks(String studentId) throws CustomException{
		StudentDTO student = manager.find(StudentDTO.class, studentId);
		Query query1 = manager.createQuery("from BatchCourseDTO where batch='"+student.getBatch()+"'", BatchCourseDTO.class);
		BatchCourseDTO res1 = (BatchCourseDTO) query1.getSingleResult();
		String tempBatch = student.getBatch();
		String tempCourse = res1.getCourseId();
		List<String> programs = getAvailablePrograms(tempCourse);
		if(programs.size()==0) throw new CustomException("Student Exception : Student with Id: "+studentId+" has not completed a program!");
		List<FeedbackDTO> feedbacks;
		List<String> feedbackGiven = new ArrayList<String>();
		Query query2 = manager.createQuery("select programid from FeedbackDTO where studentid='"+studentId+"' and programid IN :param",String.class);
		query2.setParameter("param",programs);
		feedbacks=query2.getResultList();
		programs.stream().filter(temp -> !feedbackGiven.contains(temp)).forEach(temp -> {
			FeedbackDTO ftemp = new FeedbackDTO();
			ftemp.setProgramId(temp);
			ftemp.setStudentId(studentId);
			String trainer = trainerDAO.getTrainerFromProgram(tempBatch, temp);
			if(trainer!=null){
				ftemp.setTrainerId(trainer);
				feedbacks.add(ftemp);
			}
		});
		return feedbacks;
	}

	@Override
	public boolean removeStudent(String studentId) throws CustomException {
		StudentDTO student = manager.find(StudentDTO.class, studentId);
		if(student!=null && student.isActive()) {
			student.setActive(false);
			return true;
		}
		else
			throw new CustomException("Student with Id: "+studentId+"is not active, so cannot be removed");
	}


	@Override
	public boolean validateStudent(String studentId, String pass) throws CustomException {
		StudentDTO student = manager.find(StudentDTO.class, studentId);
		if(student!=null) {
			if(student.getStudentPass().equals(pass))
				return true;
		}
		return false;
	}
	
}
