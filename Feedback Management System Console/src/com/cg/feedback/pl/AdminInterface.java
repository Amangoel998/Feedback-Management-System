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
			boolean res;
			switch (method) {
				case 1:
					ProgramDTO program = inputProgram();
					res = adm.addTrainingProgram(program);
					System.out.println((res) ? "Program Added Successfully" : "Failed to Add Program");
					break;
				case 2:
					String programId = inputProgramId();
					res = adm.removeTrainingProgram(programId);
					System.out.println((res) ? "Program Removed Successfully" : "Failed to Remove Program");
					break;
				case 3:
					StudentDTO newStudent = inputStudent();
					res = adm.addStudents(newStudent);
					System.out.println((res) ? "Student Added Successfully" : "Failed to Add Student");
					break;
				case 4:
					String studentId = inputStudentId();
					res = adm.removeStudents(studentId);
					System.out.println((res) ? "Student Removed Successfully" : "Failed to Remove Student");
					break;
				case 5:
					TrainerDTO trainer = inputTrainer();
					res = adm.addTrainer(trainer);
					System.out.println((res) ? "Trainer Added Successfully" : "Failed to Add Trainer");
					break;
				case 6:
					trainerId = inputTrainerId();
					res = adm.removeTrainer(trainerId);
					System.out.println((res) ? "Trainer Removed Successfully" : "Failed to Remove Trainer");
					break;
				case 7:
					skillName = inputSkill();
					trainerId = inputTrainerId();
					res = adm.addTrainerSkill(skillName, trainerId);
					System.out.println((res) ? "Trainer Skill Added Successfully" : "Failed to Add Trainer Skill");
					break;
				case 8:
					trainerId = inputTrainerId();
					skillName = inputSkill();
					res = adm.removeTrainerSkill(skillName, trainerId);
					System.out.println((res) ? "Trainer Skill Removed Successfully" : "Failed to Remove Trainer Skill");
					break;
				case 9:
					CourseDTO course = inputCourse();
					res = adm.addTrainingCourse(course);
					System.out.println((res) ? "Course Added Successfully" : "Failed to Add Course");
					break;
				case 10:
					courseId = inputCourseId();
					res = adm.removeTrainingCourse(courseId);
					System.out.println((res) ? "Course Removed Successfully" : "Failed to Remove Course");
					break;
				case 11:
					programId = inputProgramId();
					System.out.println(adm.viewFeedbackByProgram(programId));
					break;
				case 12:
					trainerId = inputTrainerId();
					System.out.println(adm.viewFeedbackByTrainer(trainerId));
					break;
				case 13:
					programId = inputProgramId();
					System.out.println(adm.viewFeedbackDefaultersByProgram(programId));
					break;
				case 14:
					trainerId = inputTrainerId();
					System.out.println(adm.viewFeedbackDefaultersByTrainer(trainerId));
					break;
				default:
					break;
			}
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		}
	}
}
