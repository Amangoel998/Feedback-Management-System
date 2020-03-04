package com.cg.feedback.service;

import com.cg.feedback.exceptions.CustomException;

public interface AdminService extends UserService{
	void addTrainingProgram()  throws CustomException;
	void removeTrainingProgram()  throws CustomException;
	void addStudents() throws CustomException;
	void removeStudents() throws CustomException;
	void addTrainer() throws CustomException;
	void removeTrainer() throws CustomException;
	void maintainTrainerSkillset() throws CustomException;
	void updateTrainingProgram() throws CustomException;
	void addTrainingCourse() throws CustomException;
	void removeTrainingCourse() throws CustomException;
	void viewFeedback() throws CustomException;
	void viewFeedbackDefaulters() throws CustomException;
}
