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

public class AdminServiceImpl implements AdminService{
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
//	public void getAdminMethods(int method){
//		switch(method){
//		case 1:
//			addTrainingProgram();
//			break;
//		case 2:
//			removeTrainingProgram();
//			break;
//		case 3:
//			addStudents();
//			break;
//		case 4:
//			removeStudents();
//			break;
//		case 5:
//			addTrainer();
//			break;
//		case 6:
//			removeTrainer();
//			break;
//		case 7:
//			maintainTrainerSkillset();
//			break;
//		case 8:
//			updateTrainingProgram();
//			break;
//		case 9:
//			addTrainingCourse();
//			break;
//		case 10:
//			removeTrainingCourse();
//			break;
//		case 11:
//			viewFeedback();
//			break;
//		case 12:
//			viewFeedbackDefaulters();
//			break;
//		default:
//			break;
//		}
//	}
	
	
	@Override
	public boolean logout() throws CustomException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addTrainingProgram(ProgramDTO program) throws CustomException {
		return prg.addTrainingProgram(program);
	}
	@Override
	public boolean removeTrainingProgram(String programID) throws CustomException {
		// TODO Auto-generated method stub
		return prg.removeTrainingProgram(programID);
	}
	@Override
	public boolean addStudents(StudentDTO student) throws CustomException {
		// TODO Auto-generated method stub
		return std.addStudents(student);
	}
	@Override
	public boolean removeStudents(String studentID) throws CustomException {
		// TODO Auto-generated method stub
		return std.removeStudents(studentID);
	}
	@Override
	public boolean addTrainer(TrainerDTO trainer) throws CustomException {
		// TODO Auto-generated method stub
		return trn.addTrainer(trainer);
	}
	@Override
	public boolean removeTrainer(String trainerID) throws CustomException {
		// TODO Auto-generated method stub
		return trn.removeTrainer(trainerID);
	}
	@Override
	public boolean addTrainerSkill(SkillDTO skill, String trainerId) throws CustomException {
		// TODO Auto-generated method stub
		return trn.addTrainerSkill(skill, trainerId);
	}
	@Override
	public boolean removeTrainerSkill(String skillName, String trainerId) throws CustomException {
		// TODO Auto-generated method stub
		return trn.removeTrainerSkill(skillName, trainerId);
	}
	@Override
	public boolean addTrainingCourse(CourseDTO course) throws CustomException {
		// TODO Auto-generated method stub
		return crs.addTrainingCourse(course);
	}
	@Override
	public boolean removeTrainingCourse(String courseId) throws CustomException {
		// TODO Auto-generated method stub
		return crs.removeTrainingCourse(courseId);
	}
	@Override
	public List<FeedbackDTO> viewFeedback(ProgramDAO program) throws CustomException {
		// TODO Auto-generated method stub
		return fdb.viewFeedback(program);
	}
	@Override
	public List<FeedbackDTO> viewFeedback(TrainerDTO trainer) throws CustomException {
		// TODO Auto-generated method stub
		return fdb.viewFeedback(trainer);
	}
	@Override
	public List<StudentDTO> viewFeedbackDefaulters(ProgramDAO program) throws CustomException {
		// TODO Auto-generated method stub
		return fdb.viewFeedbackDefaulters(program);
	}
	
	

}
