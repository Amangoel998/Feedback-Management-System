package com.cg.feedback.service;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.cg.feedback.dao.*;
import com.cg.feedback.dto.*;
import com.cg.feedback.exceptions.CustomException;

@Service
@Scope("singleton")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private CourseDAO crsDao;
	@Autowired
	private FeedbackDAO fdbDao;
	@Autowired
	private ProgramDAO prgDao;
	@Autowired
	private StudentDAO stdDao;
	@Autowired
	private TrainerDAO trnDao;
	@Autowired
	private AdminDAO admin;

	@Override
	public boolean login(String id, String pass) throws CustomException {
		System.out.println(pass);
		return true;
//		if(admin.validateAdmin(id, pass))
//			return true;
//		else
//			throw new CustomException("Invalid Login Credentials for Admin.");
	}
	@Override
	public boolean logout() throws CustomException {
		return true;
	}
	@Override
	public boolean addTrainingProgram(ProgramDTO program) throws CustomException {
		return prgDao.addTrainingProgram(program);
	}
	@Override
	public boolean removeTrainingProgram(String programID) throws CustomException {
		return prgDao.removeTrainingProgram(programID);
	}
	@Override
	public boolean addStudents(StudentDTO student) throws CustomException {
		return stdDao.addStudents(student);
	}
	@Override
	public boolean removeStudents(String studentID) throws CustomException {
		return stdDao.removeStudent(studentID);
	}
	@Override
	public boolean addTrainer(TrainerDTO trainer) throws CustomException {
		return trnDao.addTrainer(trainer);
	}
	@Override
	public boolean removeTrainer(String trainerID) throws CustomException {
		return trnDao.removeTrainer(trainerID);
	}
	@Override
	public boolean addTrainerSkill(String skill, String trainerId) throws CustomException {
		return trnDao.addTrainerSkill(skill, trainerId);
	}
	@Override
	public boolean removeTrainerSkill(String skillName, String trainerId) throws CustomException {
		return trnDao.removeTrainerSkill(skillName, trainerId);
	}
	@Override
	public boolean addTrainingCourse(CourseDTO course) throws CustomException {
		return crsDao.addTrainingCourse(course);
	}
	@Override
	public boolean removeTrainingCourse(String courseId) throws CustomException {
		return crsDao.removeTrainingCourse(courseId);
	}
	@Transactional
	public List<FeedbackDTO> viewFeedbackByProgram(String program) throws CustomException {
		
		return fdbDao.viewFeedbackByProgram(program);
	}
	@Override
	public List<FeedbackDTO> viewFeedbackByTrainer(String trainer) throws CustomException {
		return fdbDao.viewFeedbackByTrainer(trainer);
	}
	@Override
	public List<StudentDTO> viewFeedbackDefaultersByProgram(String program) throws CustomException {
		return fdbDao.viewFeedbackDefaultersByProgram(program);
	}
	@Override
	public Map<String,List<StudentDTO>> viewFeedbackDefaultersByTrainer(String trainer) throws CustomException {
		return fdbDao.viewFeedbackDefaultersByTrainer(trainer);
	}
}