package com.cg.feedback.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.feedback.dto.*;

public final class StaticDAO {

	private static Map<String, TrainerDTO> trainers = new HashMap<String, TrainerDTO>();
	private static Map<String, StudentDTO> students = new HashMap<String, StudentDTO>();
	private static Map<String, ProgramDTO> programs = new HashMap<String, ProgramDTO>();
	private static Map<String, CourseDTO> courses = new HashMap<String, CourseDTO>();
	private static Map<String, FeedbackDTO> feedback = new HashMap<String, FeedbackDTO>();
	private static Map<Integer, List<String>> listOfTrainerProgram = new HashMap<Integer, List<String>>();
	private static Map<Integer, List<String>> listOfProgramInCourse = new HashMap<Integer, List<String>>();
	private static Map<String, String> batchOfCourse = new HashMap<String, String>();

	static {
		trainers.put("TRN101", new TrainerDTO("TRN101", "Rahul Verma", "trainer101", "rahulverma@gmail.com"));
		trainers.put("TRN102", new TrainerDTO("TRN102", "Amit Deshpande", "trainer102", "amitdeshpande@gmail.com"));
		trainers.put("TRN103", new TrainerDTO("TRN103", "Aman Jadhav", "trainer103", "amanjadhav@gmail.com"));
		trainers.put("TRN104", new TrainerDTO("TRN104", "Raj Kashyap", "trainer104", "rajkashyap@gmail.com"));

		students.put("STD101", new StudentDTO("STD101", "Om Gupta", "student101", "ogupta261", "A"));
		students.put("STD102", new StudentDTO("STD102", "Raju Deka", "student102", "raju95", "A"));
		students.put("STD103", new StudentDTO("STD103", "Amit Yadav", "student103", "amit067", "B"));
		students.put("STD104", new StudentDTO("STD104", "Abhishek Yadav", "student104", "abhishek2002", "B"));

		programs.put("PRG101", new ProgramDTO("PRG101", "DevOps"));
		programs.put("PRG102", new ProgramDTO("PRG102", "Oracle"));
		programs.put("PRG103", new ProgramDTO("PRG103", "MVC"));
		programs.put("PRG104", new ProgramDTO("PRG104", "Spring"));

		courses.put("CRS101", new CourseDTO("CRS101", "Java Cloud"));
		courses.put("CRS102", new CourseDTO("CRS102", "Java Big Data"));
		courses.put("CRS103", new CourseDTO("CRS103", "Java "));

		feedback.put("FDB101", new FeedbackDTO("FDB101", "STD101", "TRN101", "PRG101",
				new QuestionsSetDTO(3, 4, 3, 4, 4), "Great.", "Nothing"));
		feedback.put("FDB102", new FeedbackDTO("FDB102", "STD102", "TRN101", "PRG101",
				new QuestionsSetDTO(5, 4, 3, 3, 4), "Good.", "NA"));
		feedback.put("FDB103", new FeedbackDTO("FDB103", "STD102", "TRN102", "PRG103",
				new QuestionsSetDTO(1, 1, 2, 2, 1), "BAD.", "everything"));
		feedback.put("FDB104", new FeedbackDTO("FDB104", "STD103", "TRN104", "PRG102",
				new QuestionsSetDTO(5, 3, 4, 3, 5), "LOL.", "Heh!"));

		// populating TRAINER-PROGRAM WITH BATCH NAME
		List<String> temp = new ArrayList<String>();
		temp.add("TRN101");
		temp.add("PRG101");
		temp.add("A");
		listOfTrainerProgram.put(1, temp);

		temp.clear();
		temp.add("TRN102");
		temp.add("PRG103");
		temp.add("A");
		listOfTrainerProgram.put(2, temp);

		temp.clear();
		temp.add("TRN103");
		temp.add("PRG102");
		temp.add("B");
		listOfTrainerProgram.put(3, temp);

		temp.clear();
		temp.add("TRN104");
		temp.add("PRG104");
		temp.add("B");
		listOfTrainerProgram.put(4, temp);

		temp.clear();
		temp.add("TRN101");
		temp.add("PRG103");
		temp.add("B");
		listOfTrainerProgram.put(5, temp);

		temp.clear();
		temp.add("TRN102");
		temp.add("PRG101");
		temp.add("B");
		listOfTrainerProgram.put(6, temp);

		// populating PROGRAM-COURSE WITH START-DATE AND END-DATE
		temp.clear();
		temp.add("CRS101");
		temp.add("PRG101");
		temp.add(LocalDate.of(2020, 1, 10).toString());
		temp.add(LocalDate.of(2020, 1, 17).toString());
		listOfProgramInCourse.put(1, temp);

		temp.clear();
		temp.add("CRS101");
		temp.add("PRG103");
		temp.add(LocalDate.of(2020, 1, 18).toString());
		temp.add(LocalDate.of(2020, 1, 25).toString());
		listOfProgramInCourse.put(2, temp);

		temp.clear();
		temp.add("CRS102");
		temp.add("PRG101");
		temp.add(LocalDate.of(2020, 1, 10).toString());
		temp.add(LocalDate.of(2020, 1, 17).toString());
		listOfProgramInCourse.put(3, temp);

		temp.clear();
		temp.add("CRS102");
		temp.add("PRG102");
		temp.add(LocalDate.of(2020, 1, 18).toString());
		temp.add(LocalDate.of(2020, 1, 25).toString());
		listOfProgramInCourse.put(4, temp);

		temp.clear();
		temp.add("CRS102");
		temp.add("PRG104");
		temp.add(LocalDate.of(2020, 1, 26).toString());
		temp.add(LocalDate.of(2020, 2, 5).toString());
		listOfProgramInCourse.put(5, temp);

		temp.clear();
		temp.add("CRS103");
		temp.add("PRG101");
		temp.add(LocalDate.of(2020, 2, 20).toString());
		temp.add(LocalDate.of(2020, 2, 27).toString());
		listOfProgramInCourse.put(6, temp);

		temp.clear();
		temp.add("CRS103");
		temp.add("PRG102");
		temp.add(LocalDate.of(2020, 2, 27).toString());
		temp.add(LocalDate.of(2020, 3, 5).toString());
		listOfProgramInCourse.put(7, temp);

		temp.clear();
		temp.add("CRS103");
		temp.add("PRG103");
		temp.add(LocalDate.of(2020, 3, 5).toString());
		temp.add(LocalDate.of(2020, 3, 12).toString());
		listOfProgramInCourse.put(8, temp);

		temp.clear();
		temp.add("CRS103");
		temp.add("PRG104");
		temp.add(LocalDate.of(2020, 3, 15).toString());
		temp.add(LocalDate.of(2020, 3, 25).toString());
		listOfProgramInCourse.put(9, temp);

		// populating BATCH-COURSE
		batchOfCourse.put("A", "CRS101");
		batchOfCourse.put("B", "CRS103");
	}

	public StaticDAO() {
	}

	public final Map<String, TrainerDTO> getTrainers() {
		return trainers;
	}

	public final void setTrainers(Map<String, TrainerDTO> trainers) {
		this.trainers = trainers;
	}

	public final Map<String, StudentDTO> getStudents() {
		return students;
	}

	public final void setStudents(Map<String, StudentDTO> students) {
		this.students = students;
	}

	public final Map<String, ProgramDTO> getPrograms() {
		return programs;
	}

	public final void setPrograms(Map<String, ProgramDTO> programs) {
		this.programs = programs;
	}

	public final Map<String, CourseDTO> getCourses() {
		return courses;
	}

	public final void setCourses(Map<String, CourseDTO> courses) {
		this.courses = courses;
	}

	public final Map<String, FeedbackDTO> getFeedback() {
		return feedback;
	}

	public final void setFeedback(Map<String, FeedbackDTO> feedback) {
		this.feedback = feedback;
	}

	public Map<Integer, List<String>> getListOfTrainerProgram() {
		return listOfTrainerProgram;
	}

	public void setListOfTrainerProgram(Map<Integer, List<String>> listOfTrainerProgram) {
		this.listOfTrainerProgram = listOfTrainerProgram;
	}

	public Map<Integer, List<String>> getListOfProgramInCourse() {
		return listOfProgramInCourse;
	}

	public void setListOfProgramInCourse(Map<Integer, List<String>> listOfProgramInCourse) {
		this.listOfProgramInCourse = listOfProgramInCourse;
	}

	public Map<String, String> getBatchOfCourse() {
		return batchOfCourse;
	}

	public void setBatchOfCourse(Map<String, String> batchOfCourse) {
		this.batchOfCourse = batchOfCourse;
	}

	public StudentDTO getStudent(String user) {
		return students.get(user);
	}

	public TrainerDTO getTrainer(String user) {
		return trainers.get(user);
	}

	public CourseDTO getCourse(String courseId) {
		if (courses.containsKey(courseId))
			return courses.get(courseId);
		return null;
	}

	public ProgramDTO getProgram(String programId) {
		if (programs.containsKey(programId))
			return programs.get(programId);
		return null;
	}

}
