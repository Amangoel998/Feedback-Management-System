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
	/*
	private static AdminService adm = new AdminServiceImpl();
	public void getAdminMethods(int method){
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
			adm.removeStudents("");
			break;
		case 5:
			adm.addTrainer(null);
			break;
		case 6:
			adm.removeTrainer("");
			break;
		case 7:
//			adm.maintainTrainerSkillset();
			break;
		case 8:
//			adm.updateTrainingProgram();
			break;
		case 9:
			adm.addTrainingCourse(null);
			break;
		case 10:
			adm.removeTrainingCourse("");
			break;
		case 11:
			adm.viewFeedback(new ProgramDTO("", null));
			break;
		case 12:
			adm.viewFeedbackDefaulters(null);
			break;
		default:
			break;
		}
	}
	*/
}
