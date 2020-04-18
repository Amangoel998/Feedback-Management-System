package com.cg.feedback.service;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cg.feedback.dao.FeedbackDAO;
import com.cg.feedback.dao.FeedbackDAOImpl;
import com.cg.feedback.dao.TrainerDAO;
import com.cg.feedback.dao.TrainerDAOImpl;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.exceptions.CustomException;

@Service
public class TrainerServiceImpl implements TrainerService{
	private static TrainerDAO trnDao = new TrainerDAOImpl();
	private static FeedbackDAO fdbDao = new FeedbackDAOImpl();

	@Override
	public TrainerDTO login(String id, String pass) throws CustomException {
		TrainerDTO trainer = trnDao.getTrainer(id);
		if(trainer != null){
			if(trnDao.validateTrainer(id, pass)){
				return trainer;
			}
			return null;
		}
		return trainer;
	}
	@Override
	public List<FeedbackDTO> showFeedBack(String trainerId) throws CustomException {
		List<FeedbackDTO> feedbacks = fdbDao.viewFeedbackByTrainer(trainerId);
		if(feedbacks.size()==0)
			throw new CustomException("No Feedbacks available for you!\n");
		return feedbacks;
	}

	@Override
	public Map<String,List<StudentDTO>> showDefaulters(String trainerId) throws CustomException {
		Map<String,List<StudentDTO>> defaulters = fdbDao.viewFeedbackDefaultersByTrainer(trainerId);
		if(defaulters.size()==0)
			throw new CustomException("No Defaulters available.\n");
		return defaulters;
	}

}
