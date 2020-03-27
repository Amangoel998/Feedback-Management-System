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
					adm.removeStudents("studentID");
					String studentId = inputStudentId();
					adm.removeStudents(studentId);
					break;
				case 5:
					adm.addTrainer(null);
					TrainerDTO trainer = inputTrainer();
					adm.addTrainer(trainer);
					break;
				case 6:
					adm.removeTrainer("trainerID");
					trainerId = inputTrainerId();
					adm.removeTrainer(trainerId);
					break;
				case 7:
					adm.addTrainerSkill("skillName", "trainerId");
					skillName = inputSkill();
					trainerId = inputTrainerId();
					adm.addTrainerSkill(skillName, trainerId);
					break;
				case 8:
					adm.removeTrainerSkill("skillName", "trainerId");
					trainerId = inputTrainerId();
					skillName = inputSkill();
					adm.removeTrainerSkill(skillName, trainerId);
					break;
				case 9:
					adm.addTrainingCourse(null);
					CourseDTO course = inputCourse();
					adm.addTrainingCourse(course);
					break;
				case 10:
					adm.removeTrainingCourse("courseID");
					courseId = inputCourseId();
					adm.removeTrainingCourse(courseId);
					break;
				case 11:
					adm.viewFeedbackByProgram("programID");
					programId = inputProgramId();
					adm.viewFeedbackByProgram(programId);
					break;
				case 12:
					adm.viewFeedbackByTrainer("trainerID");
					trainerId = inputTrainerId();
					adm.viewFeedbackByTrainer(trainerId);
					break;
				case 13:
					adm.viewFeedbackDefaultersByProgram("programID");
					programId = inputProgramId();
					adm.viewFeedbackDefaultersByProgram(programId);
					break;
				case 14:
					adm.viewFeedbackDefaultersByTrainer("trainerID");
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
