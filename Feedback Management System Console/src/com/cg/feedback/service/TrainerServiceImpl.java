package com.cg.feedback.service;

import java.util.List;

import com.cg.feedback.dao.FeedbackDAO;
import com.cg.feedback.dao.FeedbackDAOImpl;
import com.cg.feedback.dao.TrainerDAO;
import com.cg.feedback.dao.TrainerDAOImpl;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.exceptions.CustomException;

public class TrainerServiceImpl implements TrainerService {
	private static TrainerDAO trnDao = new TrainerDAOImpl();
	private static FeedbackDAO fdbDao = new FeedbackDAOImpl();

	private static TrainerDTO trainer = null;

	public String getTrainerMethods(int method) throws CustomException {
		if (trainer == null)
			throw new CustomException("Trainer Not Logged In !!");
		if (method == 1)
			return showFeedBack();
		else if (method == 2)
			return showDefaulters();
		else
			return "WRONG OPTION";
	}

	@Override
	public boolean login(String id, String pass) throws CustomException {
		trainer = trnDao.getTrainer(id);
		if (trainer != null) {
			if (trnDao.validateTrainer(id, pass)) {
				return true;
			}
			trainer = null;
			return false;
		}
		return false;
	}

	@Override
	public boolean logout() throws CustomException {
		if (trainer == null)
			throw new CustomException("Trainer Not Logged In !!");
		else {
			trainer = null;
			return true;
		}
	}

	@Override
	public String showFeedBack() throws CustomException {
		if (trainer == null)
			throw new CustomException("Trainer Not Logged In !!");
		List<FeedbackDTO> feedbacks = fdbDao.viewFeedbackByTrainer(trainer.getTrainerId());
		if (feedbacks.size() == 0)
			throw new CustomException("No Feedbacks available for you!\n");
		else {
			String res = "";
			for (FeedbackDTO temp : feedbacks)
				res += temp;
			return res;
		}
	}

	@Override
	public String showDefaulters() throws CustomException {
		if (trainer == null)
			throw new CustomException("Trainer Not Logged In !!");
		List<StudentDTO> defaulters = fdbDao.viewFeedbackDefaultersByTrainer(trainer.getTrainerId());
		String res = "";
		if (defaulters.size() == 0)
			throw new CustomException("No Defaulters available.\n");
		else {
			for (StudentDTO temp : defaulters)
				res += temp;
		}
		return res;
	}

}
