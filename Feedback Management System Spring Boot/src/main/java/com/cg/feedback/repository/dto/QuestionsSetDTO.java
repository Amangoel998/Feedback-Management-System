package com.cg.feedback.repository.dto;

public class QuestionsSetDTO {
	private int q1, q2, q3, q4, q5;

	public QuestionsSetDTO(int q1, int q2, int q3, int q4, int q5) {
		super();
		this.q1 = q1;
		this.q2 = q2;
		this.q3 = q3;
		this.q4 = q4;
		this.q5 = q5;
	}

	public int getQ1() {
		return q1;
	}

	public int getQ2() {
		return q2;
	}

	public int getQ3() {
		return q3;
	}

	public int getQ4() {
		return q4;
	}

	public int getQ5() {
		return q5;
	}
}
