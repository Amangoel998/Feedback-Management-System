package com.cg.feedback.service;

import java.util.List;

import com.cg.feedback.dao.ProgramDAO;
import com.cg.feedback.dto.CourseDTO;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.dto.SkillDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.exceptions.CustomException;

public interface AdminService extends UserService{
	boolean addTrainingProgram(ProgramDTO program)  throws CustomException;
	boolean removeTrainingProgram(String programID)  throws CustomException;
	boolean addStudents(StudentDTO student) throws CustomException;
	boolean removeStudents(String studentID) throws CustomException;
	boolean addTrainer(TrainerDTO trainer) throws CustomException;
	boolean removeTrainer(String trainerID) throws CustomException;
	boolean addTrainerSkill(SkillDTO skill,String trainerId) throws CustomException;
	boolean removeTrainerSkill(String skillName,String trainerId) throws CustomException;
	boolean addTrainingCourse(CourseDTO course) throws CustomException;
	boolean removeTrainingCourse(String courseId) throws CustomException;
	List<FeedbackDTO> viewFeedback(ProgramDAO program) throws CustomException;
	List<FeedbackDTO> viewFeedback(TrainerDTO trainer) throws CustomException;
	List<StudentDTO> viewFeedbackDefaulters(ProgramDAO program) throws CustomException;
}
