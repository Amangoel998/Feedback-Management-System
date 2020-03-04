package com.cg.feedback.service;

import com.cg.feedback.exceptions.CustomException;

public interface UserService {

	boolean login(String id, String pass) throws CustomException;
	boolean logout() throws CustomException;
}
