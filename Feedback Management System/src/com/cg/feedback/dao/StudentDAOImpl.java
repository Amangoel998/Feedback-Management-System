package com.cg.feedback.dao;

import java.util.Map;

import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.QuestionsSetDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.exceptions.CustomException;

public class StudentDAOImpl implements StudentDAO {

	Map<String, StudentDTO> students=new StaticDAO().getStudents();

	@Override
	public void giveFeedback(QuestionsSetDTO feedbackSet) throws CustomException {
	
		
	}

	@Override
	public boolean addStudents(StudentDTO student) throws CustomException {
		
		if(students.containsKey(student.getStudentId()))
		{
			throw new CustomException("Student with Id: "+student.getStudentId()+" already exists.");
		}
		else{
			students.put(student.getStudentId(), student);
			return true;
		}
	}

	@Override
	public boolean removeStudents(String studentID) throws CustomException {
		if(students.containsKey(studentID))
		{
			students.remove(studentID);
			return true;
		}
		else
			throw new CustomException("Cannot find student with ID: "+studentID);
	}
	
}
