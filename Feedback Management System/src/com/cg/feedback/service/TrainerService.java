package com.cg.feedback.service;

import com.cg.feedback.exceptions.CustomException;

public interface TrainerService extends UserService{
	String showFeedBack(String trainerId) throws CustomException;
	String showDefaulters(String trainerId) throws CustomException;
}
