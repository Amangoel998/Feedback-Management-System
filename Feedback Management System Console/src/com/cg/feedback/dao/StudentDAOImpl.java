package com.cg.feedback.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.exceptions.CustomException;

public class StudentDAOImpl implements StudentDAO {
	StaticDAO staticDb = new StaticDAO();
	TrainerDAO trainerDAO = new TrainerDAOImpl();

	@Override
	public StudentDTO getStudent(String user) throws CustomException {
		StudentDTO student = staticDb.getStudent(user);
		if (student != null)
			return student;
		else
			throw new CustomException("Student with Id: " + user + " not present");
	}

	@Override
	public boolean addStudents(StudentDTO student) throws CustomException {

		if (staticDb.getStudents().containsKey(student.getStudentId())) {
			StudentDTO temp = staticDb.getStudents().get(student.getStudentId());
			if (temp.isActive())
				throw new CustomException(
						"Student Exception : Student with Id: " + student.getStudentId() + " already exists.");
			else {
				temp.setActive(true);
				throw new CustomException("Student Exception : Student with Id: " + student.getStudentId()
						+ " already exists and status has been set to active.");
			}
		} else {
			staticDb.getStudents().put(student.getStudentId(), student);
			return true;
		}
	}

	@Override
	public List<String> getAvailablePrograms(String studentId) throws CustomException {
		String tempCourse = staticDb.getBatchOfCourse().get(staticDb.getStudent(studentId).getBatch());
		return staticDb.getListOfProgramInCourse().values().stream().filter(temp -> {
			if (temp.get(0).equals(tempCourse) && LocalDate.parse(temp.get(3)).isBefore(LocalDate.now()))
				return true;
			return false;
		}).map(temp -> temp.get(1)).collect(Collectors.toList());
	}

	@Override
	public List<FeedbackDTO> getAvailableFeedbacks(String studentId) throws CustomException {
		String tempBatch = staticDb.getStudent(studentId).getBatch();
		String tempCourse = staticDb.getBatchOfCourse().get(tempBatch);
		List<String> programs = getAvailablePrograms(studentId);
		if (programs.size() == 0)
			throw new CustomException(
					"Student Exception : Student with Id: " + studentId + " is not in a running program!");
		List<FeedbackDTO> feedbacks = new ArrayList<FeedbackDTO>();
		List<String> feedbackGiven = new ArrayList<String>();
		staticDb.getFeedback().values().stream()
				.filter(temp -> temp.getStudentId() == studentId && programs.contains(temp.getProgramId()))
				.forEach(temp -> feedbackGiven.add(temp.getProgramId()));
		programs.stream().filter(temp -> !feedbackGiven.contains(temp)).forEach(temp -> {
			FeedbackDTO ftemp = new FeedbackDTO();
			ftemp.setProgramId(temp);
			ftemp.setStudentId(studentId);
			String trainer = trainerDAO.getTrainerFromProgram(tempBatch, temp);
			if (trainer != null) {
				ftemp.setTrainerId(trainer);
				feedbacks.add(ftemp);
			}
		});
		return feedbacks;
	}

	@Override
	public boolean removeStudent(String studentID) throws CustomException {
		if (staticDb.getStudents().containsKey(studentID) && staticDb.getStudents().get(studentID).isActive()) {
			staticDb.getStudents().get(studentID).setActive(false);
			return true;
		} else
			throw new CustomException("Student with Id: " + studentID + " is not active, so cannot be removed");
	}

	@Override
	public boolean validateStudent(String user, String pass) throws CustomException {
		if (getStudent(user).getStudentPass().equals(pass))
			return true;
		return false;
	}

}
