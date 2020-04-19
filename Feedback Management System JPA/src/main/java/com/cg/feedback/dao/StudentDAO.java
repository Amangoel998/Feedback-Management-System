package com.cg.feedback.dao;

import com.cg.feedback.exceptions.CustomException;
import java.util.List;
import java.util.Map;

import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.StudentDTO;

public interface StudentDAO {
	boolean addStudents(StudentDTO student) throws CustomException;
	boolean removeStudent(String studentID) throws CustomException;
	boolean validateStudent(String user, String pass) throws CustomException;
	StudentDTO getStudent(String user) throws CustomException;
	List<String> getAvailablePrograms(String course) throws CustomException;
	Map<String, FeedbackDTO> getAvailableFeedbacks(String studentId) throws CustomException;
	List<String> getStudents() throws CustomException;
}
