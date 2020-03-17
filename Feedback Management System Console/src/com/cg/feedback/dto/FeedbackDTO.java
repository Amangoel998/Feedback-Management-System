package com.cg.feedback.dto;

public class FeedbackDTO {

	private String feedbackId;
	private String studentId;
	private String trainerId;
	private String programId;
	private QuestionsSetDTO questions;
	private String Comments;
	private String suggestions;
	
	public FeedbackDTO(){
		super();
	}
	
	
	public FeedbackDTO(String feedbackId, String studentId, String trainerId, String programId,
			QuestionsSetDTO questions, String comments, String suggestions) {
		super();
		this.feedbackId = feedbackId;
		this.studentId = studentId;
		this.trainerId = trainerId;
		this.programId = programId;
		this.questions = questions;
		Comments = comments;
		this.suggestions = suggestions;
	}
	
	@Override
	public String toString() {
		return "FeedbackDTO [feedbackId=" + feedbackId + ", studentId=" + studentId + ", trainerId=" + trainerId
				+ ", programId=" + programId + ", questions=" + questions + ", Comments=" + Comments + ", suggestions="
				+ suggestions + "]";
	}


	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public String getTrainerId() {
		return trainerId;
	}


	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}


	public String getProgramId() {
		return programId;
	}


	public void setProgramId(String programId) {
		this.programId = programId;
	}


	public String getSuggestions() {
		return suggestions;
	}


	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}


	public void setQuestions(QuestionsSetDTO questions) {
		this.questions = questions;
	}


	public String getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
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
		if(temp.getStudentId().equals(this.studentId) && temp.getProgramId().equals(this.programId) && temp.getTrainerId().equals(this.trainerId))
			return true;
		return false;
	}
	
}
