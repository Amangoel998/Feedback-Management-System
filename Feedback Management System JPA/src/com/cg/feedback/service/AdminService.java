package com.cg.feedback.service;

import java.util.List;
import com.cg.feedback.dto.CourseDTO;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.exceptions.CustomException;

public interface AdminService extends UserService{
	boolean addTrainingProgram(ProgramDTO program)  throws CustomException;
	boolean removeTrainingProgram(String programId)  throws CustomException;
	boolean addStudents(StudentDTO student) throws CustomException;
	boolean removeStudents(String studentID) throws CustomException;
	boolean addTrainer(TrainerDTO trainer) throws CustomException;
	boolean removeTrainer(String trainerID) throws CustomException;
	boolean addTrainerSkill(String skill,String trainerId) throws CustomException;
	boolean removeTrainerSkill(String skillName,String trainerId) throws CustomException;
	boolean addTrainingCourse(CourseDTO course) throws CustomException;
	boolean removeTrainingCourse(String courseId) throws CustomException;
	List<FeedbackDTO> viewFeedbackByProgram(String program) throws CustomException;
	List<FeedbackDTO> viewFeedbackByTrainer(String trainer) throws CustomException;
	List<StudentDTO> viewFeedbackDefaultersByProgram(String program) throws CustomException;
	List<StudentDTO> viewFeedbackDefaultersByTrainer(String trainer) throws CustomException;
}
