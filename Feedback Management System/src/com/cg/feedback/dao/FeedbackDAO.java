package com.cg.feedback.dao;

import com.cg.feedback.exceptions.CustomException;

public interface FeedbackDAO {
	void viewFeedback() throws CustomException;
	void viewFeedbackDefaulters() throws CustomException;
}
