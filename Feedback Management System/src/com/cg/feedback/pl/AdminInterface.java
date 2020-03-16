package com.cg.feedback.pl;
import java.util.List;

import static com.cg.feedback.utility.Input.*;

import com.cg.feedback.dao.ProgramDAO;
import com.cg.feedback.dto.CourseDTO;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.dto.SkillDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.exceptions.CustomException;
import com.cg.feedback.service.AdminService;
import com.cg.feedback.service.AdminServiceImpl;

public class AdminInterface {
	private static AdminService adm = new AdminServiceImpl();
	public static void getAdminMethods(int method){
		switch(method){
		case 1:
			ProgramDTO program = inputProgram();
			adm.addTrainingProgram(program);
			break;
		case 2:
			String programId = inputProgramId();
			adm.removeTrainingProgram(programId);
			break;
		case 3:
			StudentDTO newStudent = inputStudent(); 
			adm.addStudents(newStudent);
			break;
		case 4:
			adm.removeStudents("studentID");
			break;
		case 5:
			adm.addTrainer(null);
			break;
		case 6:
			adm.removeTrainer("trainerID");
			break;
		case 7:
			adm.addTrainerSkill("skillName", "trainerId");
			break;
		case 8:
			adm.removeTrainerSkill("skillName", "trainerId");
			break;
		case 9:
			adm.addTrainingCourse(null);
			break;
		case 10:
			adm.removeTrainingCourse("courseID");
			break;
		case 11:
			adm.viewFeedbackByProgram("programID");
			break;
		case 12:
			adm.viewFeedbackByTrainer("trainerID");
			break;
		case 13:
			adm.viewFeedbackDefaultersByProgram("programID");
			break;
		case 14:
			adm.viewFeedbackDefaultersByTrainer("trainerID");
			break;
		default:
			break;
		}
	}
}
