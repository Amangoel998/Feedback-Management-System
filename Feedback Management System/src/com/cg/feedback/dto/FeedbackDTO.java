package com.cg.feedback.dto;


public class FeedbackDTO {

	private String feedbackId;
	private StudentDTO sudent;
	private TrainerDTO trainer;
	private ProgramDTO program;
	private QuestionsSetDTO questions;
	private String Comments;
	private String suggestions;
	
	

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
	public programDTO getprogram() {
		return program;
	}
	public void setprogram(programDTO program) {
		this.program = program;
	}
		
	public QuestionsSetDTO getQuestions() {
		return questions;
	}
	
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	
	
	
	
	
}
