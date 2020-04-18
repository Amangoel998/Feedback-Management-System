package com.cg.feedback.service;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;


import com.cg.feedback.dao.*;
import com.cg.feedback.dto.*;
import com.cg.feedback.exceptions.CustomException;

public class AdminServiceImpl implements AdminService{

	private CourseDAO crsDao = new CourseDAOImpl();
	private FeedbackDAO fdbDao = new FeedbackDAOImpl();
	private ProgramDAO prgDao = new ProgramDAOImpl();
	private StudentDAO stdDao = new StudentDAOImpl();
	private TrainerDAO trnDao = new TrainerDAOImpl();
	private AdminDAO admin = new AdminDAOImpl();

	@Override
	public boolean login(String id, String pass) throws CustomException {
		if(admin.validateAdmin(id, pass))
			return true;
		else
			throw new CustomException("Invalid Login Credentials for Admin.");
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
	public ReportDTO viewFeedbackByTrainer(String trainer) throws CustomException {
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
	public boolean addPrograminCourse(ProgramCourseDTO programs) throws CustomException {
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