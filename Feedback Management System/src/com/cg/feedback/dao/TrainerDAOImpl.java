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
			throw new CustomException("Trainer with Id: "+trainer.getTrainerId()+" already exists.");
		}
		else
		{
			trainers.put(trainer.getTrainerId(),trainer);
			return true;
		}
	}

	@Override
	public boolean removeTrainer(String trainerId) throws CustomException {
		if(trainers.containsKey(trainerId))
		{
			trainers.remove(trainerId);
			return true;
		}
		else
		{
			throw new CustomException("Trainer with Id: "+trainerId+"does not exist");
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
