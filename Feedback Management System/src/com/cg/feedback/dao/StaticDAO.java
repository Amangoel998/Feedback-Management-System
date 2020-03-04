package com.cg.feedback.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.feedback.dto.*;

public final class StaticDAO {
	
	private Map<Integer, TrainerDTO> trainers = new HashMap<Integer, TrainerDTO>();
	private Map<Integer, StudentDTO> students = new HashMap<Integer, StudentDTO>();
	private Map<Integer, ProgramDTO> programs = new HashMap<Integer, ProgramDTO>();
	private Map<Integer, CourseDTO> courses = new HashMap<Integer, CourseDTO>();
	private Map<Integer, FeedbackDTO> feedback = new HashMap<Integer, FeedbackDTO>();
	
	public final Map<Integer, TrainerDTO> getTrainers() {
		return trainers;
	}
	public final void setTrainers(Map<Integer, TrainerDTO> trainers) {
		this.trainers = trainers;
	}
	public final Map<Integer, StudentDTO> getStudents() {
		return students;
	}
	public final void setStudents(Map<Integer, StudentDTO> students) {
		this.students = students;
	}
	public final Map<Integer, ProgramDTO> getPrograms() {
		return programs;
	}
	public final void setPrograms(Map<Integer, ProgramDTO> programs) {
		this.programs = programs;
	}
	public final Map<Integer, CourseDTO> getCourses() {
		return courses;
	}
	public final void setCourses(Map<Integer, CourseDTO> courses) {
		this.courses = courses;
	}
	public final Map<Integer, FeedbackDTO> getFeedback() {
		return feedback;
	}
	public final void setFeedback(Map<Integer, FeedbackDTO> feedback) {
		this.feedback = feedback;
	}
	
}
