package com.cg.feedback.service;

import java.util.List;
import java.util.Map;

import com.cg.feedback.dto.AdminDTO;
import com.cg.feedback.dto.BatchCourseDTO;
import com.cg.feedback.dto.CourseDTO;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.ProgramCourseDTO;
import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.dto.TrainerProgramDTO;
import com.cg.feedback.exceptions.CustomException;

public interface AdminService{

	AdminDTO login(String id, String pass) throws CustomException;

	boolean addTrainingProgram(ProgramDTO program)  throws CustomException;
	boolean addStudents(StudentDTO student) throws CustomException;
	boolean addTrainer(TrainerDTO trainer) throws CustomException;
	boolean addTrainerSkill(String skill,String trainerId) throws CustomException;
	boolean addTrainingCourse(CourseDTO course) throws CustomException;
	
	boolean assignPrograminCourse(ProgramCourseDTO programs) throws CustomException;
	boolean assignTrainertoProgram(TrainerProgramDTO trainer) throws CustomException;
	boolean assignCourseToBatch(BatchCourseDTO batches) throws CustomException;
	
	boolean removeStudents(String studentID) throws CustomException;
	boolean removeTrainingProgram(String programId)  throws CustomException;
	boolean removeTrainer(String trainerID) throws CustomException;
	boolean removeTrainerSkill(String skillName,String trainerId) throws CustomException;
	boolean removeTrainingCourse(String courseId) throws CustomException;
	
	List<FeedbackDTO> viewFeedbackByProgram(String program) throws CustomException;
	List<FeedbackDTO> viewFeedbackByTrainer(String trainer) throws CustomException;
	
	List<StudentDTO> viewFeedbackDefaultersByProgram(String program) throws CustomException;
	Map<String, List<StudentDTO>> viewFeedbackDefaultersByTrainer(String trainer) throws CustomException;
	
	List<String> getCourses() throws CustomException;
	List<String> getTrainers() throws CustomException;
	List<String> getStudents() throws CustomException;
	List<String> getPrograms() throws CustomException;
	
	List<String> availableBatches() throws CustomException;
	
	List<String> availablePrograms(String batch);
	List<String> getAvailableTrainers(String batchId);
	
}
