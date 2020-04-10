package com.cg.feedback.repository.service;

import java.util.List;
import java.util.Map;

import com.cg.feedback.repository.dto.BatchCourseDTO;
import com.cg.feedback.repository.dto.CourseDTO;
import com.cg.feedback.repository.dto.FeedbackDTO;
import com.cg.feedback.repository.dto.ProgramCourseDTO;
import com.cg.feedback.repository.dto.ProgramDTO;
import com.cg.feedback.repository.dto.StudentDTO;
import com.cg.feedback.repository.dto.TrainerDTO;
import com.cg.feedback.repository.dto.TrainerProgramDTO;
import com.cg.feedback.repository.exceptions.CustomException;

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
	Map<String, List<StudentDTO>> viewFeedbackDefaultersByTrainer(String trainer) throws CustomException;
	boolean addPrograminCourse(ProgramCourseDTO programs) throws CustomException;
	List<String> availableBatches() throws CustomException;
	boolean assignTrainertoProgram(TrainerProgramDTO trainer) throws CustomException;
	boolean assignCourseToBatch(BatchCourseDTO batches) throws CustomException;
	List<String> getCourses() throws CustomException;
	List<String> getTrainers() throws CustomException;
	List<String> getStudents() throws CustomException;
	List<String> getPrograms() throws CustomException;
	List<String> availablePrograms(String batch);
	List<String> getAvailableTrainers(String batchId);
	
}
