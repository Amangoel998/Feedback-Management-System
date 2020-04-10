package com.cg.feedback.repository.dao;

import com.cg.feedback.repository.exceptions.CustomException;
import java.util.List;

import com.cg.feedback.repository.dto.FeedbackDTO;
import com.cg.feedback.repository.dto.StudentDTO;

public interface StudentDAO {
	boolean addStudents(StudentDTO student) throws CustomException;
	boolean removeStudent(String studentID) throws CustomException;
	boolean validateStudent(String user, String pass) throws CustomException;
	StudentDTO getStudent(String user) throws CustomException;
	List<String> getAvailablePrograms(String course) throws CustomException;
	List<FeedbackDTO> getAvailableFeedbacks(String studentId) throws CustomException;
	List<String> getStudents() throws CustomException;
}
