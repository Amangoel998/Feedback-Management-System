package com.cg.feedback.dao;

import java.util.Map;

import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.QuestionsSetDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.exceptions.CustomException;

public class StudentDAOImpl implements StudentDAO {

	Map<String, StudentDTO> students=new StaticDAO().getStudents();

	@Override
	public boolean addStudents(StudentDTO student) throws CustomException {
		
		if(students.containsKey(student.getStudentId())) {
			StudentDTO temp = students.get(student.getStudentId());
			if(temp.isActive())
				throw new CustomException("Student with Id: "+student.getStudentId()+" already exists.");
			else{
				temp.setActive(true);
				throw new CustomException("Student with Id: "+student.getStudentId()+" already exists and status has been set to active.");
			}
		}
		else{
			students.put(student.getStudentId(), student);
			return true;
		}
	}

	@Override
	public boolean removeStudents(String studentID) throws CustomException {
		if(students.containsKey(studentID) && students.get(studentID).isActive()) {
			students.get(studentID).setActive(false);
			return true;
		}
		else
			throw new CustomException("Student with Id: "+studentID+"is not active, so cannot be removed");
	}
	
}
