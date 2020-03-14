package com.cg.feedback.dao;

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
	private static Map<Integer, List> listOfTrainerProgram = new HashMap<Integer, List>();
	private static Map<Integer, List> listOfProgramInCourse = new HashMap<Integer, List>();
	private static Map<String, String> batchOfCourse = new HashMap<String, String>();
	
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

	public Map<Integer, List> getListOfTrainerProgram() {
		return listOfTrainerProgram;
	}

	public void setListOfTrainerProgram(Map<Integer, List> listOfTrainerProgram) {
		this.listOfTrainerProgram = listOfTrainerProgram;
	}

	public Map<Integer, List> getListOfProgramInCourse() {
		return listOfProgramInCourse;
	}

	public void setListOfProgramInCourse(Map<Integer, List> listOfProgramInCourse) {
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

}
