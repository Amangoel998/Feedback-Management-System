package com.cg.feedback.service;

import java.util.List;

import com.cg.feedback.dao.CourseDAO;
import com.cg.feedback.dao.CourseDAOImpl;
import com.cg.feedback.dao.FeedbackDAO;
import com.cg.feedback.dao.FeedbackDAOImpl;
import com.cg.feedback.dao.ProgramDAO;
import com.cg.feedback.dao.ProgramDAOImpl;
import com.cg.feedback.dao.StudentDAO;
import com.cg.feedback.dao.StudentDAOImpl;
import com.cg.feedback.dao.TrainerDAO;
import com.cg.feedback.dao.TrainerDAOImpl;
import com.cg.feedback.dto.AdminDTO;
import com.cg.feedback.dto.CourseDTO;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.dto.SkillDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.exceptions.CustomException;

public class AdminServiceImpl{
	/*
	private static CourseDAO crs = new CourseDAOImpl();
	private static FeedbackDAO fdb = new FeedbackDAOImpl();
	private static ProgramDAO prg = new ProgramDAOImpl();
	private static StudentDAO std = new StudentDAOImpl();
	private static TrainerDAO trn = new TrainerDAOImpl();
	
	
	
	@Override
	public boolean login(String id, String pass) throws CustomException {
		if(AdminDTO.validateAdmin(id, pass))
			return true;
		else
			throw new CustomException("Invalid Login Credentials for Admin.");
	}
	@Override
	public boolean logout() throws CustomException {
		return false;
	}
	@Override
	public boolean addTrainingProgram(ProgramDTO program) throws CustomException {
		return prg.addTrainingProgram(program);
	}
	@Override
	public boolean removeTrainingProgram(String programID) throws CustomException {
		return prg.removeTrainingProgram(programID);
	}
	@Override
	public boolean addStudents(StudentDTO student) throws CustomException {
		return std.addStudents(student);
	}
	@Override
	public boolean removeStudents(String studentID) throws CustomException {
		return std.removeStudents(studentID);
	}
	@Override
	public boolean addTrainer(TrainerDTO trainer) throws CustomException {
		return trn.addTrainer(trainer);
	}
	@Override
	public boolean removeTrainer(String trainerID) throws CustomException {
		return trn.removeTrainer(trainerID);
	}
	@Override
	public boolean addTrainerSkill(SkillDTO skill, String trainerId) throws CustomException {
		return trn.addTrainerSkill(skill, trainerId);
	}
	@Override
	public boolean removeTrainerSkill(String skillName, String trainerId) throws CustomException {
		return trn.removeTrainerSkill(skillName, trainerId);
	}
	@Override
	public boolean addTrainingCourse(CourseDTO course) throws CustomException {
		return crs.addTrainingCourse(course);
	}
	@Override
	public boolean removeTrainingCourse(String courseId) throws CustomException {
		return crs.removeTrainingCourse(courseId);
	}
	@Override
	public List<FeedbackDTO> viewFeedback(ProgramDTO program) throws CustomException {
		return fdb.viewFeedback(program);
	}
	@Override
	public List<FeedbackDTO> viewFeedback(TrainerDTO trainer) throws CustomException {
		return fdb.viewFeedback(trainer);
	}
	@Override
	public List<StudentDTO> viewFeedbackDefaulters(ProgramDTO program) throws CustomException {
		return fdb.viewFeedbackDefaulters(program);
	}
	*/
}
