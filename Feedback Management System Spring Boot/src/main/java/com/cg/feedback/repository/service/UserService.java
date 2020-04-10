package com.cg.feedback.repository.service;

import com.cg.feedback.repository.exceptions.CustomException;

public interface UserService {
	boolean login(String id, String pass) throws CustomException;
	boolean logout() throws CustomException;
}
