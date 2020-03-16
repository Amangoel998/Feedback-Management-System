package com.cg.feedback.dao;

import com.cg.feedback.exceptions.CustomException;
import java.util.List;

import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.StudentDTO;

public interface StudentDAO {
	boolean addStudents(StudentDTO student) throws CustomException;
	boolean removeStudent(String studentID) throws CustomException;
	boolean validateStudent(String user, String pass) throws CustomException;
	StudentDTO getStudent(String user) throws CustomException;
	List<String> getProgramsWithFeedback(String studentId) throws CustomException;
	List<String> getAvailablePrograms(String studentId) throws CustomException;
	List<FeedbackDTO> getAvailableFeedbacks(String studentId) throws CustomException;
}
