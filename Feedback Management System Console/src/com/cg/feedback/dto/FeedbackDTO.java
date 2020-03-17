package com.cg.feedback.dto;

import com.cg.feedback.dao.ProgramDAO;

public class FeedbackDTO {

	private String feedbackId;
	private StudentDTO student;
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
	public StudentDTO getStudent() {
		return student;
	}
	public void setStudent(StudentDTO sudent) {
		this.student = sudent;
	}
	public TrainerDTO getTrainer() {
		return trainer;
	}
	public void setTrainer(TrainerDTO trainer) {
		this.trainer = trainer;
	}
	public ProgramDTO getProgram() {
		return program;
	}
	public void setProgram(ProgramDTO program) {
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
	@Override
	public boolean equals(Object obj) {
		FeedbackDTO temp = (FeedbackDTO) obj;
		if(temp.getStudent().equals(this.student) && temp.getProgram().equals(this.program) && temp.getTrainer().equals(this.trainer))
			return true;
		return false;
	}
	
}