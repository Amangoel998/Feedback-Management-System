package com.cg.feedback.service;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.feedback.dao.*;
import com.cg.feedback.dto.*;
import com.cg.feedback.exceptions.CustomException;

@Service
public class AdminServiceImpl implements AdminService{
	private CourseDAO crsDao;
	private FeedbackDAO fdbDao;
	private ProgramDAO prgDao;
	private StudentDAO stdDao;
	private TrainerDAO trnDao;
	private AdminDAO admin;
	
	@Autowired
	public AdminServiceImpl(){
		this.crsDao = new CourseDAOImpl();
		this.fdbDao = new FeedbackDAOImpl();
		this.prgDao = new ProgramDAOImpl();
		this.stdDao = new StudentDAOImpl();
		this.trnDao = new TrainerDAOImpl();
		this.admin = new AdminDAOImpl();
	}

	@Override
	public AdminDTO login(String id, String pass) throws CustomException {
		AdminDTO result = admin.validateAdmin(id, pass);
		return result;
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
	@Override
	public boolean assignPrograminCourse(ProgramCourseDTO programs) throws CustomException {
		return admin.addPrograminCourse(programs);
	}
	@Override
	public List<String> availableBatches() throws CustomException {
		return admin.availableBatches();
	}
	@Override
	public boolean assignTrainertoProgram(TrainerProgramDTO trainer) throws CustomException {
		return admin.assignTrainertoProgram(trainer);
	}
	@Override
	public boolean assignCourseToBatch(BatchCourseDTO batches) throws CustomException {
		return admin.assignCourseToBatch(batches);
	}
	@Override
	public List<String> getCourses() throws CustomException {
		return crsDao.getCourses();
	}
	@Override
	public List<String> getTrainers() throws CustomException {
		return trnDao.getTrainers();
	}
	@Override
	public List<String> getStudents() throws CustomException {
		return stdDao.getStudents();
	}
	@Override
	public List<String> getPrograms() throws CustomException {
		return prgDao.getPrograms();
	}
	@Override
	public List<String> availablePrograms(String batch) {
		return prgDao.availablePrograms(batch);
	}
	@Override
	public List<String> getAvailableTrainers(String batchId) {
		return trnDao.getAvailableTrainers(batchId);
	}
}