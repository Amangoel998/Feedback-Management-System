package com.cg.feedback.dao;

import com.cg.feedback.exceptions.CustomException;
import java.util.List;

import com.cg.feedback.dto.StudentDTO;

public interface StudentDAO {
	boolean addStudents(StudentDTO student) throws CustomException;
	boolean removeStudents(String studentID) throws CustomException;
	
	StudentDTO getStudent(String user, String pass) throws CustomException;
	List<String> getProgramsWithFeedback(String studentId) throws CustomException;
	
	
}
