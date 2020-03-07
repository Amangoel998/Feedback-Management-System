package com.cg.feedback.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.feedback.dto.*;

public final class StaticDAO {
	
	private Map<String, TrainerDTO> trainers = new HashMap<String, TrainerDTO>();
	private Map<String, StudentDTO> students = new HashMap<String, StudentDTO>();
	private Map<String, ProgramDTO> programs = new HashMap<String, ProgramDTO>();
	private Map<String, CourseDTO> courses = new HashMap<String, CourseDTO>();
	private Map<String, FeedbackDTO> feedback = new HashMap<String, FeedbackDTO>();
	
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
	
}
