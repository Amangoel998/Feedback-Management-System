package com.cg.feedback.service;

import java.util.List;
import java.util.Map;

import com.cg.feedback.dao.*;
import com.cg.feedback.dto.*;
import com.cg.feedback.exceptions.CustomException;

public class AdminServiceImpl implements AdminService {
	private static CourseDAO crsDao = new CourseDAOImpl();
	private static FeedbackDAO fdbDao = new FeedbackDAOImpl();
	private static ProgramDAO prgDao = new ProgramDAOImpl();
	private static StudentDAO stdDao = new StudentDAOImpl();
	private static TrainerDAO trnDao = new TrainerDAOImpl();
	private static AdminDAO adm = new AdminDAOImpl();
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
	public Map<String,List<StudentDTO>> viewFeedbackDefaultersByTrainer(String trainer) throws CustomException {
		return fdbDao.viewFeedbackDefaultersByTrainer(trainer);
	}
	@Override
	public boolean addPrograminCourse(List<String> programs) throws CustomException {
		return adm.addPrograminCourse(programs);
	}
	@Override
	public List<String> availableBatches() throws CustomException {
		return adm.availableBatches();
	}
	@Override
	public boolean assignTrainertoProgram(List<String> trainer) throws CustomException {
		return adm.assignTrainertoProgram(trainer);
	}
	@Override
	public boolean assignCourseToBatch(List<String> batches) throws CustomException {
		return adm.assignCourseToBatch(batches);
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