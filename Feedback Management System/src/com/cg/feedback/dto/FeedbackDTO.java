package com.cg.feedback.dto;

import java.util.ArrayList;

public class FeedbackDTO {

	private String feedbackId;
	private StudentDTO sudent;
	private TrainerDTO trainer;
	private CourseDTO course;
	private ArrayList<String> feedback;
	private String Comments;
	
	
	public String getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}
	public StudentDTO getSudent() {
		return sudent;
	}
	public void setSudent(StudentDTO sudent) {
		this.sudent = sudent;
	}
	public TrainerDTO getTrainer() {
		return trainer;
	}
	public void setTrainer(TrainerDTO trainer) {
		this.trainer = trainer;
	}
	public CourseDTO getCourse() {
		return course;
	}
	public void setCourse(CourseDTO course) {
		this.course = course;
	}
	public ArrayList<String> getFeedback() {
		return feedback;
	}
	public void setFeedback(ArrayList<String> feedback) {
		this.feedback = feedback;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	
	
	
	
	
}
