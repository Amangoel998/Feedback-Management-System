package com.cg.feedback.dao;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.dto.TrainerProgramDTO;
import com.cg.feedback.exceptions.CustomException;

@Repository
public class TrainerDAOImpl implements TrainerDAO{
	StaticDAO staticDb = new StaticDAO();
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public TrainerDTO getTrainer(String trainerId) throws CustomException {
		
		TrainerDTO trainer = manager.find(TrainerDTO.class, trainerId);
		if (trainer != null)
			return trainer;
		else
			throw new CustomException("Trainer with Id: " + trainerId + " not present");
	}

	@Override
	public boolean addTrainer(TrainerDTO trainer) throws CustomException {
		
		TrainerDTO temp = manager.find(TrainerDTO.class, trainer.getTrainerId());
		if (temp!=null) {
			if (temp.isActive())
				throw new CustomException("Trainer with Id: " + trainer.getTrainerId()
						+ " is already present and active.");
			else {
				temp.setActive(true);
				throw new CustomException(
						"Trainer with Id: " + trainer.getTrainerId() + " is already present and has been set active.");
			}
		} else {
			manager.persist(trainer);
			return true;
		}
	}

	@Override
	public boolean removeTrainer(String trainerId) throws CustomException {
		
		TrainerDTO temp = manager.find(TrainerDTO.class, trainerId);
		
		if (temp!=null && temp.isActive()) {
			temp.setActive(false);
			return true;
		} else {
			throw new CustomException("Trainer with Id: " + trainerId + "is not active, so cannot be removed!");
		}

	}

	@Override
	public boolean addTrainerSkill(String skill, String trainerId) throws CustomException {
		TrainerDTO temp = manager.find(TrainerDTO.class, trainerId);
		if(temp==null)
			throw new CustomException("Trainer with Id: " + trainerId + "is not present!");
		String skillDB = temp.getSkills();
		List<String> skills = Arrays.asList(skillDB.split(","));
		if (skills.contains(skill)) {
			throw new CustomException("Skill aready exists");
		} else {
			if(skills.size()==1) {
				if(skills.get(0).length()==0)
					temp.setSkills(skill);
				else
					temp.setSkills(skillDB+","+skill);
			}
			return true;
		}
	}

	@Override
	public boolean removeTrainerSkill(String skillName, String trainerId) throws CustomException {
		TrainerDTO temp = manager.find(TrainerDTO.class, trainerId);
		if(temp==null)
			throw new CustomException("Trainer with Id: " + trainerId + "is not present!");
		String skillDB = temp.getSkills();
		List<String> skills = Arrays.asList(skillDB.split(","));
		boolean flag = false;
		for (int i = 0; i < skills.size(); i++) {
			if (skills.get(i).equals(skillName)) {
				flag=true;
				break;
			}
		}
		if(flag)
			temp.setSkills(skills.stream().filter(skill->!skill.equals(skillName)).reduce((skill1,skill2) -> skill1+","+skill2).get());
		else
			throw new CustomException("Skill not present in Trainer Skill-set.");
		return flag;
	}

	@Override
	public boolean validateTrainer(String trainerId, String pass) throws CustomException {
		TrainerDTO temp = manager.find(TrainerDTO.class, trainerId);
		if(temp!=null) {
			if(temp.getTrainerPass().equals(pass))
				return true;
			
		}
		return false;
	}

	@Override
	public String getTrainerFromProgram(String batchId, String programsId) {
		Query query = manager.createQuery("From TrainerProgramDTO where batch='"+batchId+"' and programid='"+programsId+"'");
		TrainerProgramDTO temp;
		try {
			temp = (TrainerProgramDTO) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		return temp.getTrainerId();
	}
}
