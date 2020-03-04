package com.cg.feedback.service;

import com.cg.feedback.exceptions.CustomException;

public class AdminServiceImpl implements AdminService{

	@Override
	public boolean login(String id, String pass) throws CustomException {
		// TODO Auto-generated method stub
		return false;
	}
	public void getAdminMethods(int method){
		switch(method){
		case 1:
			addTrainingProgram();
			break;
		case 2:
			removeTrainingProgram();
			break;
		case 3:
			addStudents();
			break;
		case 4:
			removeStudents();
			break;
		case 5:
			addTrainer();
			break;
		case 6:
			removeTrainer();
			break;
		case 7:
			maintainTrainerSkillset();
			break;
		case 8:
			updateTrainingProgram();
			break;
		case 9:
			addTrainingCourse();
			break;
		case 10:
			removeTrainingCourse();
			break;
		case 11:
			viewFeedback();
			break;
		case 12:
			viewFeedbackDefaulters();
			break;
		default:
			break;
		}
	}
	
	
	@Override
	public boolean logout() throws CustomException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addTrainingProgram() throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTrainingProgram() throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addStudents() throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeStudents() throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTrainer() throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTrainer() throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void maintainTrainerSkillset() throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTrainingProgram() throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTrainingCourse() throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTrainingCourse() throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewFeedback() throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewFeedbackDefaulters() throws CustomException {
		// TODO Auto-generated method stub
		
	}

}
