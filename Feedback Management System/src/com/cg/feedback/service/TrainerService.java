package com.cg.feedback.service;

import com.cg.feedback.exceptions.CustomException;

public interface TrainerService extends UserService{
	void showFeedBack() throws CustomException;
	void showDefaulters() throws CustomException;
}
