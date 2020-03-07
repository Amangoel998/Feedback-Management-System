package com.cg.feedback.dao;

import com.cg.feedback.dto.QuestionsSetDTO;
import com.cg.feedback.exceptions.CustomException;
import java.util.HashMap;
import java.util.Map;

import com.cg.feedback.dto.StudentDTO;

public interface StudentDAO {
	boolean addStudents(StudentDTO student) throws CustomException;
	boolean removeStudents(String studentID) throws CustomException;
}
