package com.cg.feedback.repository.service;


import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.cg.feedback.repository.dao.FeedbackDAO;
import com.cg.feedback.repository.dao.FeedbackDAOImpl;
import com.cg.feedback.repository.dao.TrainerDAO;
import com.cg.feedback.repository.dao.TrainerDAOImpl;
import com.cg.feedback.repository.dto.FeedbackDTO;
import com.cg.feedback.repository.dto.StudentDTO;
import com.cg.feedback.repository.dto.TrainerDTO;
import com.cg.feedback.repository.exceptions.CustomException;

@Service
@Scope("singleton")
public class TrainerServiceImpl implements TrainerService{
	private static TrainerDAO trnDao = new TrainerDAOImpl();
	private static FeedbackDAO fdbDao = new FeedbackDAOImpl();

	private static TrainerDTO trainer = null;

	public String getTrainerMethods(int method) throws CustomException{
		if(trainer==null)
			throw new CustomException("Trainer Not Logged In !!");
		if(method==1)
			return showFeedBack();
		else if(method==2)
			return showDefaulters();
		else
			return "WRONG OPTION";
	}

	@Override
	public boolean login(String id, String pass) throws CustomException {
		trainer = trnDao.getTrainer(id);
		if(trainer != null){
			if(trnDao.validateTrainer(id, pass)){
				return true;
			}
			trainer = null;
			return false;
		}
		return false;
	}

	@Override
	public boolean logout() throws CustomException {
		if(trainer==null)
			throw new CustomException("Trainer Not Logged In !!");
		else {
			trainer = null;
			return true;
		}
	}

	@Override
	public String showFeedBack() throws CustomException {
		if(trainer==null)
			throw new CustomException("Trainer Not Logged In !!");
		List<FeedbackDTO> feedbacks = fdbDao.viewFeedbackByTrainer(trainer.getTrainerId());
		if(feedbacks.size()==0)
			throw new CustomException("No Feedbacks available for you!\n");
		else{
			String res = "";
			if(feedbacks.size()==0)
				res+="No available feedbacks for you!";
			for(FeedbackDTO temp : feedbacks)
				res+="\t"+temp+"\n";
			return res;
		}
	}

	@Override
	public String showDefaulters() throws CustomException {
		if(trainer==null)
			throw new CustomException("Trainer Not Logged In !!");
		Map<String,List<StudentDTO>> defaulters = fdbDao.viewFeedbackDefaultersByTrainer(trainer.getTrainerId());
		String res = "";
		if(defaulters.size()==0)
			throw new CustomException("No Defaulters available.\n");
		else{
			for(Map.Entry<String, List<StudentDTO>> me : defaulters.entrySet()) {
				res+=me.getKey()+":\n";
				List<StudentDTO> temp = me.getValue();
				if(temp.size()==0) {
					res+="\tNo Defaulters in this program!";
				}
				for(StudentDTO std : temp) {
					res+="\t"+std+"\n";
				}
				res+="\n";
			}
		}
		return res;
	}

}
