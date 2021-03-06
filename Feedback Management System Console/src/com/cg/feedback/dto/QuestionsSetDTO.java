package com.cg.feedback.dto;

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
	
	@Override
	public String toString() {
		return " q1=" + q1 + ", q2=" + q2 + ", q3=" + q3 + ", q4=" + q4 + ", q5=" + q5 + " ";
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

	public void addRating(long[] ques_sum) {
		ques_sum[0] += q1;
		ques_sum[1] += q2;
		ques_sum[2] += q3;
		ques_sum[3] += q4;
		ques_sum[4] += q5;
	}
}
