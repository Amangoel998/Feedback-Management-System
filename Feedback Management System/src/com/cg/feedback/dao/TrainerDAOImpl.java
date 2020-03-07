package com.cg.feedback.dao;

import java.util.List;
import java.util.Map;

import com.cg.feedback.dto.SkillDTO;
import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.exceptions.CustomException;

public class TrainerDAOImpl implements TrainerDAO {
	Map<String,TrainerDTO> trainers= new StaticDAO().getTrainers();

	@Override
	public boolean addTrainer(TrainerDTO trainer) throws CustomException {
		if(trainers.containsKey(trainer.getTrainerId())){
			TrainerDTO temp = trainers.get(trainer.getTrainerId());
			if(temp.isActive())
				throw new CustomException("Trainer with Id: "+trainer.getTrainerId()+" is already present and active. First delete the existing trainer to overwrite.");
			else{
				temp.setActive(true);
				throw new CustomException("Trainer with Id: "+trainer.getTrainerId()+" is already present and has been set active.");
			}
		}
		else
		{
			trainers.put(trainer.getTrainerId(),trainer);
			return true;
		}
	}

	@Override
	public boolean removeTrainer(String trainerId) throws CustomException {
		if(trainers.containsKey(trainerId) && trainers.get(trainerId).isActive())
		{
			trainers.get(trainerId).setActive(false);
			return true;
		}
		else
		{
			throw new CustomException("Trainer with Id: "+trainerId+"is not active, so cannot be removed");
		}
		
	}

	@Override
	public boolean addTrainerSkill(SkillDTO skill,String trainerId) throws CustomException {
		List<SkillDTO>skills=trainers.get(trainerId).getSkill();
		if(skills.contains(skill))
		{
			throw new CustomException("Skill aready exists");
		}
		else{
			skills.add(skill);
			return true;
		}
	}

	@Override
	public boolean removeTrainerSkill(String skillName,String trainerId) throws CustomException {
		List<SkillDTO>skills=trainers.get(trainerId).getSkill();
		for(int i=0;i<skills.size();i++)
		{
			if(skills.get(i).getSkillName().equals(skillName))
			{	skills.remove(i);
				return true;
			}
		}
		throw new CustomException("Skill not present in Trainer Skill-set.");
	}


}
