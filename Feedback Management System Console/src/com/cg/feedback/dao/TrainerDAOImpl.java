package com.cg.feedback.dao;

import java.util.List;
import java.util.Map;

import com.cg.feedback.dto.SkillDTO;
import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.exceptions.CustomException;

public class TrainerDAOImpl{
	/*
	StaticDAO staticDb = new StaticDAO();

	@Override
	public TrainerDTO getTrainer(String user, String pass) throws CustomException {
		TrainerDTO trainer = staticDb.getTrainers().get(user);
		if (trainer != null)
			return trainer;
		else
			throw new CustomException("Trainer with Id: " + user + " not present");
	}

	@Override
	public boolean addTrainer(TrainerDTO trainer) throws CustomException {
		if (staticDb.getTrainers().containsKey(trainer.getTrainerId())) {
			TrainerDTO temp = staticDb.getTrainers().get(trainer.getTrainerId());
			if (temp.isActive())
				throw new CustomException("Trainer with Id: " + trainer.getTrainerId()
						+ " is already present and active. First delete the existing trainer to overwrite.");
			else {
				temp.setActive(true);
				throw new CustomException(
						"Trainer with Id: " + trainer.getTrainerId() + " is already present and has been set active.");
			}
		} else {
			staticDb.getTrainers().put(trainer.getTrainerId(), trainer);
			return true;
		}
	}

	@Override
	public boolean removeTrainer(String trainerId) throws CustomException {
		if (staticDb.getTrainers().containsKey(trainerId) && staticDb.getTrainers().get(trainerId).isActive()) {
			staticDb.getTrainers().get(trainerId).setActive(false);
			return true;
		} else {
			throw new CustomException("Trainer with Id: " + trainerId + "is not active, so cannot be removed");
		}

	}

	@Override
	public boolean addTrainerSkill(SkillDTO skill, String trainerId) throws CustomException {
		List<SkillDTO> skills = staticDb.getTrainers().get(trainerId).getSkill();
		if (skills.contains(skill)) {
			throw new CustomException("Skill aready exists");
		} else {
			skills.add(skill);
			return true;
		}
	}

	@Override
	public boolean removeTrainerSkill(String skillName, String trainerId) throws CustomException {
		List<SkillDTO> skills = staticDb.getTrainers().get(trainerId).getSkill();
		for (int i = 0; i < skills.size(); i++) {
			if (skills.get(i).getSkillName().equals(skillName)) {
				skills.remove(i);
				return true;
			}
		}
		throw new CustomException("Skill not present in Trainer Skill-set.");
	}
	*/
}
