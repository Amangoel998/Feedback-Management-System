package com.cg.feedback.pl;
import static com.cg.feedback.utility.Input.*;

import com.cg.feedback.dto.CourseDTO;
import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.exceptions.CustomException;
import com.cg.feedback.service.AdminService;
import com.cg.feedback.service.AdminServiceImpl;

public class AdminInterface {
	private static AdminService adm = new AdminServiceImpl();
	/*
	 * Admin interface will obviously not print anything because return type has not been observed carefully.
	 * Some method return String, boolean, please modify getAdminmethod to print something or return string so we can see the output.
	 * Same thing needs to be checked in service methods for student and trainer.
	 * ALSO modify the UI for accepting all the admin methods. it is not showing all the methods.
	*/
	public static void getAdminMethods(int method) {
		try {
			String trainerId;
			String skillName;
			String courseId;
			switch (method) {
				case 1:
					ProgramDTO program = inputProgram();
					adm.addTrainingProgram(program);
					break;
				case 2:
					String programId = inputProgramId();
					programId = inputProgramId();
					adm.removeTrainingProgram(programId);
					break;
				case 3:
					StudentDTO newStudent = inputStudent();
					adm.addStudents(newStudent);
					break;
				case 4:
					String studentId = inputStudentId();
					adm.removeStudents(studentId);
					break;
				case 5:
					TrainerDTO trainer = inputTrainer();
					adm.addTrainer(trainer);
					break;
				case 6:
					trainerId = inputTrainerId();
					adm.removeTrainer(trainerId);
					break;
				case 7:
					skillName = inputSkill();
					trainerId = inputTrainerId();
					adm.addTrainerSkill(skillName, trainerId);
					break;
				case 8:
					trainerId = inputTrainerId();
					skillName = inputSkill();
					adm.removeTrainerSkill(skillName, trainerId);
					break;
				case 9:
					CourseDTO course = inputCourse();
					adm.addTrainingCourse(course);
					break;
				case 10:
					courseId = inputCourseId();
					adm.removeTrainingCourse(courseId);
					break;
				case 11:
					programId = inputProgramId();
					adm.viewFeedbackByProgram(programId);
					break;
				case 12:
					trainerId = inputTrainerId();
					adm.viewFeedbackByTrainer(trainerId);
					break;
				case 13:
					programId = inputProgramId();
					adm.viewFeedbackDefaultersByProgram(programId);
					break;
				case 14:
					trainerId = inputTrainerId();
					adm.viewFeedbackDefaultersByTrainer(trainerId);
					break;
				default:
					break;
			}
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		}
	}
}
