package com.cg.feedback.service;


import java.util.List;

import com.cg.feedback.dao.FeedbackDAO;
import com.cg.feedback.dao.FeedbackDAOImpl;
import com.cg.feedback.dao.TrainerDAO;
import com.cg.feedback.dao.TrainerDAOImpl;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.exceptions.CustomException;
import com.cg.feedback.pl.AuthInterface;

public class TrainerServiceImpl implements TrainerService{
	
	private static TrainerDAO trn = new TrainerDAOImpl();
	private static AuthInterface auth = new AuthInterface();
	private static FeedbackDAO fdb = new FeedbackDAOImpl();
	
	public String getTrainerMethods(int method,String trainerId) throws CustomException{
		if(method==1)
			return showFeedBack(trainerId);
		else if(method==2)
			return showDefaulters(trainerId);
		else
			return "WRONG OPTION";
	}
	
	@Override
	public boolean login(String id, String pass) throws CustomException {
		return trn.validateTrainer(id, pass);
	}

	@Override
	public boolean logout() throws CustomException {
		return auth.logout();
	}

	@Override
	public String showFeedBack(String trainerId) throws CustomException {
		List<FeedbackDTO> feedbacks = fdb.viewFeedbackByTrainer(trainerId);
		if(feedbacks.size()==0)
			throw new CustomException("No Feedbacks have been given for you!");
		else{

			String res = "";
			for(FeedbackDTO temp : feedbacks)
				res+=temp;
			return res;
		}
	}

	@Override
	public String showDefaulters(String trainerId) throws CustomException {
		List<StudentDTO> defaulters = fdb.viewFeedbackDefaultersByTrainer(trainerId);
		if(defaulters.size()==0)
			throw new CustomException("No Defaulters have been given for you!");
		else{
	
			String res = "";
			for(StudentDTO temp : defaulters)
				res+=temp;
			return res;
		}
	}

}
