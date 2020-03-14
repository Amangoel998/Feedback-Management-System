package com.cg.feedback.dao;

import java.util.List;
import java.util.Map;

import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.QuestionsSetDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.exceptions.CustomException;

public class StudentDAOImpl{
	/*
	StaticDAO staticDb = new StaticDAO();

	@Override
	public StudentDTO getStudent(String user, String pass) throws CustomException {
		StudentDTO student = staticDb.getStudent(user);
		if (student != null)
			return student;
		else
			throw new CustomException("Student with Id: " + user + " not present");
	}
	
	@Override
	public boolean addStudents(StudentDTO student) throws CustomException {
		
		if(staticDb.getStudents().containsKey(student.getStudentId())) {
			StudentDTO temp = staticDb.getStudents().get(student.getStudentId());
			if(temp.isActive())
				throw new CustomException("Student with Id: "+student.getStudentId()+" already exists.");
			else{
				temp.setActive(true);
				throw new CustomException("Student with Id: "+student.getStudentId()+" already exists and status has been set to active.");
			}
		}
		else{
			staticDb.getStudents().put(student.getStudentId(), student);
			return true;
		}
	}
	
	public List<String> getAvaiablePrograms() throws CustomException {
		// TODO get program ids
		return null;
	}
	public List<FeedbackDTO> getAvaiiableFeedbacks() throws CustomException{
		return null;
	}

	@Override
	public boolean removeStudents(String studentID) throws CustomException {
		if(staticDb.getStudents().containsKey(studentID) && staticDb.getStudents().get(studentID).isActive()) {
			staticDb.getStudents().get(studentID).setActive(false);
			return true;
		}
		else
			throw new CustomException("Student with Id: "+studentID+"is not active, so cannot be removed");
	}
	*/
}
