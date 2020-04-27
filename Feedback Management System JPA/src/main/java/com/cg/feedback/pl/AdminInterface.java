package com.cg.feedback.pl;

import static com.cg.feedback.utility.Input.*;

import java.util.List;

import com.cg.feedback.dto.BatchCourseDTO;
import com.cg.feedback.dto.CourseDTO;
import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.dto.TrainerProgramDTO;
import com.cg.feedback.exceptions.CustomException;
import com.cg.feedback.service.AdminService;
import com.cg.feedback.service.AdminServiceImpl;

public class AdminInterface {
	private static AdminService adm = new AdminServiceImpl();

	static int index = 1;
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
					StudentDTO newStudent = inputStudent(adm.availableBatches());
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
					List<String> availablePrograms = adm.getPrograms();
					System.out.println("Available Programs - ");
					availablePrograms.stream().forEach(temp->System.out.println(availablePrograms.indexOf(temp)+":"+temp));
					inputPrograms(course.getCourseId(),availablePrograms).stream().forEach(temp->adm.addPrograminCourse(temp));
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
					index = 1;
					adm.viewFeedbackDefaultersByProgram(programId).stream().forEach(temp -> System.out.println((index++)+" - "+temp));
					System.out.println();
					break;
				case 14:
					trainerId = inputTrainerId();
					adm.viewFeedbackDefaultersByTrainer(trainerId).entrySet().stream().forEach(temp -> {
						System.out.println(temp.getKey()+":");
						index=1;
						for(StudentDTO tempS : temp.getValue()) {
							System.out.println("\t"+(index++)+" - "+tempS);
						}
						if(temp.getValue().size()==0)
							System.out.println("\tNo Defaulters!");
					});
					break;
				case 15:
					if(adm.assignCourseToBatch(new BatchCourseDTO(inputCourseId(adm.getCourses()),inputNewBatch(adm.availableBatches())))) {
						System.out.println("Assigned Course to Batch!");
					}else System.out.println("Failed to assign Course to Batch!");
					break;
				case 16:
					String batch = inputBatch(adm.availableBatches());
					if(batch==null) throw new CustomException("No Batches available!");
					programId = inputProgramId(adm.availablePrograms(batch));
					if(programId==null) throw new CustomException("No programs available for the batch!");
					trainerId = inputTrainerId(adm.getAvailableTrainers(batch));
					if(trainerId==null) throw new CustomException("No trainers available for the batch!");
					if(adm.assignTrainertoProgram(new TrainerProgramDTO(trainerId, programId, batch))) {
						System.out.println("Assigned Trainer to Program!");
					}else System.out.println("Failed to assign Trainer to Program!");
					break;
				default:
					break;
			}
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		}
	}
}
