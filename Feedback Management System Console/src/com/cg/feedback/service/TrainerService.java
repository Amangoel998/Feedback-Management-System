package com.cg.feedback.service;

import com.cg.feedback.exceptions.CustomException;

public interface TrainerService extends UserService{
	String showFeedBack() throws CustomException;
	String showDefaulters() throws CustomException;
}