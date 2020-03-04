package com.cg.feedback.service;


import com.cg.feedback.exceptions.CustomException;

public class TrainerServiceImpl implements TrainerService {
	
	public void getTrainerMethods(int method){
		switch(method){
		case 1:
			showFeedBack();
			break;
		case 2:
			showDefaulters();
			break;
		default:
		}
	}
	
	@Override
	public boolean login(String id, String pass) throws CustomException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logout() throws CustomException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void showFeedBack() throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showDefaulters() throws CustomException {
		// TODO Auto-generated method stub
		
	}

}
