package com.cg.feedback.repository.service;

import com.cg.feedback.repository.exceptions.CustomException;

public interface TrainerService extends UserService{
	String showFeedBack() throws CustomException;
	String showDefaulters() throws CustomException;
}