package com.cg.feedback.repository.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="feedback")
public class FeedbackDTO {

	@Id
	@Column(name="feedbackid", updatable=false)
	private String feedbackId;
	
	@Column(name="studentid", updatable=false)
	private String studentId;
	
	@Column(name="trainerid", updatable=false)
	private String trainerId;
	
	@Column(name="programid", updatable=false)
	private String programId;
	
	@Column(name="q1", updatable=false)
	private int q1;
	
	@Column(name="q2", updatable=false)
	private int q2;
	
	@Column(name="q3", updatable=false)
	private int q3;
	
	@Column(name="q4", updatable=false)
	private int q4;
	
	@Column(name="q5", updatable=false)
	private int q5;
	
	@Column(name="comments", updatable=false)
	private String comments;
	
	@Column(name="suggestions", updatable=false)
	private String suggestions;
	
	public FeedbackDTO(){
		super();
	}
	
	@Override
	public String toString() {
		return "FeedbackDTO [feedbackId=" + feedbackId + ", studentId=" + studentId + ", trainerId=" + trainerId
				+ ", programId=" + programId + ", q1=" + q1 + ", q2=" + q2 + ", q3=" + q3 + ", q4=" + q4 + ", q5=" + q5
				+ ", comments=" + comments + ", suggestions=" + suggestions + "]";
	}

	public FeedbackDTO(String feedbackId, String studentId, String trainerId, String programId, int q1, int q2, int q3,
			int q4, int q5, String comments, String suggestions) {
		super();
		this.feedbackId = feedbackId;
		this.studentId = studentId;
		this.trainerId = trainerId;
		this.programId = programId;
		this.q1 = q1;
		this.q2 = q2;
		this.q3 = q3;
		this.q4 = q4;
		this.q5 = q5;
		this.comments = comments;
		this.suggestions = suggestions;
	}



	public String getFeedbackId() {
		return feedbackId;
	}



	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
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



	public int getQ1() {
		return q1;
	}



	public void setQ1(int q1) {
		this.q1 = q1;
	}



	public int getQ2() {
		return q2;
	}



	public void setQ2(int q2) {
		this.q2 = q2;
	}



	public int getQ3() {
		return q3;
	}



	public void setQ3(int q3) {
		this.q3 = q3;
	}



	public int getQ4() {
		return q4;
	}



	public void setQ4(int q4) {
		this.q4 = q4;
	}



	public int getQ5() {
		return q5;
	}



	public void setQ5(int q5) {
		this.q5 = q5;
	}



	public String getComments() {
		return comments;
	}



	public void setComments(String comments) {
		this.comments = comments;
	}



	public String getSuggestions() {
		return suggestions;
	}



	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}



	@Override
	public boolean equals(Object obj) {
		FeedbackDTO temp = (FeedbackDTO) obj;
		if(temp.getStudentId().equals(this.studentId) && temp.getProgramId().equals(this.programId) && temp.getTrainerId().equals(this.trainerId))
			return true;
		return false;
	}

	@Transient
	public void setQuestions(QuestionsSetDTO takeQuestions) {
		setQ1(takeQuestions.getQ1());
		setQ2(takeQuestions.getQ2());
		setQ3(takeQuestions.getQ3());
		setQ4(takeQuestions.getQ4());
		setQ5(takeQuestions.getQ5());
	}
	
}
