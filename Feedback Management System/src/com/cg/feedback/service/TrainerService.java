package com.cg.feedback.service;

import com.cg.feedback.exceptions.CustomException;

public interface TrainerService {
	boolean login(String id, String pass) throws CustomException;
	void showFeedBack() throws CustomException;
	void viewDefaulters() throws CustomException;
	boolean logout() throws CustomException;
}
