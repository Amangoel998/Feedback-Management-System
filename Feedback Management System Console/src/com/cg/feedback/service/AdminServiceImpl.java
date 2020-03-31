package com.cg.feedback.service;

import java.util.List;

import com.cg.feedback.dao.*;
import com.cg.feedback.dto.*;
import com.cg.feedback.exceptions.CustomException;

public class AdminServiceImpl implements AdminService {
	private static CourseDAO crsDao = new CourseDAOImpl();
	private static FeedbackDAO fdbDao = new FeedbackDAOImpl();
	private static ProgramDAO prgDao = new ProgramDAOImpl();
	private static StudentDAO stdDao = new StudentDAOImpl();
	private static TrainerDAO trnDao = new TrainerDAOImpl();

	private static AdminDTO admin = null;

	@Override
	public boolean login(final String id, final String pass) throws CustomException {
		if (admin != null)
			throw new CustomException("Admin Already Logged In !!");
		admin = AdminDTO.validateAdmin(id, pass);
		if (admin != null)
			return true;
		else
			throw new CustomException("Invalid Login Credentials for Admin.");
	}

	@Override
	public boolean logout() throws CustomException {
		if (admin == null)
			throw new CustomException("Admin Not Logged In !!");
		else {
			admin = null;
			return true;
		}
	}

	@Override
	public boolean addTrainingProgram(final ProgramDTO program) throws CustomException {
		if (admin == null)
			throw new CustomException("Admin Not Logged In !!");
		return prgDao.addTrainingProgram(program);
	}

	@Override
	public boolean removeTrainingProgram(final String programID) throws CustomException {
		if (admin == null)
			throw new CustomException("Admin Not Logged In !!");
		return prgDao.removeTrainingProgram(programID);
	}

	@Override
	public boolean addStudents(final StudentDTO student) throws CustomException {
		if (admin == null)
			throw new CustomException("Admin Not Logged In !!");
		return stdDao.addStudents(student);
	}

	@Override
	public boolean removeStudents(final String studentID) throws CustomException {
		if (admin == null)
			throw new CustomException("Admin Not Logged In !!");
		return stdDao.removeStudent(studentID);
	}

	@Override
	public boolean addTrainer(final TrainerDTO trainer) throws CustomException {
		if (admin == null)
			throw new CustomException("Admin Not Logged In !!");
		return trnDao.addTrainer(trainer);
	}

	@Override
	public boolean removeTrainer(final String trainerID) throws CustomException {
		if (admin == null)
			throw new CustomException("Admin Not Logged In !!");
		return trnDao.removeTrainer(trainerID);
	}

	@Override
	public boolean addTrainerSkill(final String skill, final String trainerId) throws CustomException {
		if (admin == null)
			throw new CustomException("Admin Not Logged In !!");
		return trnDao.addTrainerSkill(skill, trainerId);
	}

	@Override
	public boolean removeTrainerSkill(final String skillName, final String trainerId) throws CustomException {
		if (admin == null)
			throw new CustomException("Admin Not Logged In !!");
		return trnDao.removeTrainerSkill(skillName, trainerId);
	}

	@Override
	public boolean addTrainingCourse(final CourseDTO course) throws CustomException {
		if (admin == null)
			throw new CustomException("Admin Not Logged In !!");
		return crsDao.addTrainingCourse(course);
	}

	@Override
	public boolean removeTrainingCourse(final String courseId) throws CustomException {
		if (admin == null)
			throw new CustomException("Admin Not Logged In !!");
		return crsDao.removeTrainingCourse(courseId);
	}

	@Override
	public ReportDTO viewFeedbackByProgram(final String program) throws CustomException {
		if (admin == null)
			throw new CustomException("Admin Not Logged In !!");
		return new ReportDTO(fdbDao.viewFeedbackByProgram(program));
	}

	@Override
	public ReportDTO viewFeedbackByTrainer(final String trainer) throws CustomException {
		if (admin == null)
			throw new CustomException("Admin Not Logged In !!");
		return new ReportDTO(fdbDao.viewFeedbackByTrainer(trainer));
	}

	@Override
	public List<StudentDTO> viewFeedbackDefaultersByProgram(final String program) throws CustomException {
		if (admin == null)
			throw new CustomException("Admin Not Logged In !!");
		return fdbDao.viewFeedbackDefaultersByProgram(program);
	}

	@Override
	public List<StudentDTO> viewFeedbackDefaultersByTrainer(final String trainer) throws CustomException {
		if (admin == null)
			throw new CustomException("Admin Not Logged In !!");
		return fdbDao.viewFeedbackDefaultersByTrainer(trainer);
	}
}