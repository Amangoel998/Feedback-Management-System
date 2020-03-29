package com.cg.feedback.service;
import java.util.List;

import com.cg.feedback.dao.*;
import com.cg.feedback.dto.*;
import com.cg.feedback.exceptions.CustomException;

public class AdminServiceImpl implements AdminService{
	private static CourseDAO crsDao = new CourseDAOImpl();
	private static FeedbackDAO fdbDao = new FeedbackDAOImpl();
	private static ProgramDAO prgDao = new ProgramDAOImpl();
	private static StudentDAO stdDao = new StudentDAOImpl();
	private static TrainerDAO trnDao = new TrainerDAOImpl();

	private static AdminDTO admin = null;

	@Override
	public boolean login(String id, String pass) throws CustomException {
		if(admin!=null)
			throw new CustomException("Admin Already Logged In !!");
		admin = AdminDTO.validateAdmin(id, pass);
		if(admin!=null)
			return true;
		else
			throw new CustomException("Invalid Login Credentials for Admin.");
	}
	@Override
	public boolean logout() throws CustomException {
		if(admin==null)
			throw new CustomException("Admin Not Logged In !!");
		else {
			admin = null;
			return true;
		}
	}
	@Override
	public boolean addTrainingProgram(ProgramDTO program) throws CustomException {
		if(admin==null)
			throw new CustomException("Admin Not Logged In !!");
		return prgDao.addTrainingProgram(program);
	}
	@Override
	public boolean removeTrainingProgram(String programID) throws CustomException {
		if(admin==null)
			throw new CustomException("Admin Not Logged In !!");
		return prgDao.removeTrainingProgram(programID);
	}
	@Override
	public boolean addStudents(StudentDTO student) throws CustomException {
		if(admin==null)
			throw new CustomException("Admin Not Logged In !!");
		return stdDao.addStudents(student);
	}
	@Override
	public boolean removeStudents(String studentID) throws CustomException {
		if(admin==null)
			throw new CustomException("Admin Not Logged In !!");
		return stdDao.removeStudent(studentID);
	}
	@Override
	public boolean addTrainer(TrainerDTO trainer) throws CustomException {
		if(admin==null)
			throw new CustomException("Admin Not Logged In !!");
		return trnDao.addTrainer(trainer);
	}
	@Override
	public boolean removeTrainer(String trainerID) throws CustomException {
		if(admin==null)
			throw new CustomException("Admin Not Logged In !!");
		return trnDao.removeTrainer(trainerID);
	}
	@Override
	public boolean addTrainerSkill(String skill, String trainerId) throws CustomException {
		if(admin==null)
			throw new CustomException("Admin Not Logged In !!");
		return trnDao.addTrainerSkill(skill, trainerId);
	}
	@Override
	public boolean removeTrainerSkill(String skillName, String trainerId) throws CustomException {
		if(admin==null)
			throw new CustomException("Admin Not Logged In !!");
		return trnDao.removeTrainerSkill(skillName, trainerId);
	}
	@Override
	public boolean addTrainingCourse(CourseDTO course) throws CustomException {
		if(admin==null)
			throw new CustomException("Admin Not Logged In !!");
		return crsDao.addTrainingCourse(course);
	}
	@Override
	public boolean removeTrainingCourse(String courseId) throws CustomException {
		if(admin==null)
			throw new CustomException("Admin Not Logged In !!");
		return crsDao.removeTrainingCourse(courseId);
	}
	@Override
	public List<FeedbackDTO> viewFeedbackByProgram(String program) throws CustomException {
		if(admin==null)
			throw new CustomException("Admin Not Logged In !!");
		return fdbDao.viewFeedbackByProgram(program);
	}
	@Override
	public List<FeedbackDTO> viewFeedbackByTrainer(String trainer) throws CustomException {
		if(admin==null)
			throw new CustomException("Admin Not Logged In !!");
		return fdbDao.viewFeedbackByTrainer(trainer);
	}
	@Override
	public List<StudentDTO> viewFeedbackDefaultersByProgram(String program) throws CustomException {
		if(admin==null)
			throw new CustomException("Admin Not Logged In !!");
		return fdbDao.viewFeedbackDefaultersByProgram(program);
	}
	@Override
	public List<StudentDTO> viewFeedbackDefaultersByTrainer(String trainer) throws CustomException {
		if(admin==null)
			throw new CustomException("Admin Not Logged In !!");
		return fdbDao.viewFeedbackDefaultersByTrainer(trainer);
	}
}