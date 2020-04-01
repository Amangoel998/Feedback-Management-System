package com.cg.feedback.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.feedback.dto.ProgramCourseDTO;
import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.dto.TrainerProgramDTO;
import com.cg.feedback.exceptions.CustomException;

@Repository
public class TrainerDAOImpl implements TrainerDAO{

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Feedback Management System JPA");
	private EntityManager manager = emf.createEntityManager();

	@Override
	public TrainerDTO getTrainer(String trainerId) throws CustomException {
		
		TrainerDTO trainer = manager.find(TrainerDTO.class, trainerId);
		if (trainer != null)
			return trainer;
		else
			throw new CustomException("Trainer with Id: " + trainerId + " not present");
	}
	
	@Override
	public List<String> getTrainers() throws CustomException {
		return manager.createQuery("from TrainerDTO where isactive=1",TrainerDTO.class).getResultList().stream().map(temp->temp.getTrainerId()+"-"+temp.getTrainerName()).collect(Collectors.toList());
	}

	@Override
	public boolean addTrainer(TrainerDTO trainer) throws CustomException {

		if(!manager.getTransaction().isActive())manager.getTransaction().begin();
		TrainerDTO temp = manager.find(TrainerDTO.class, trainer.getTrainerId());
		if (temp!=null) {
			if (temp.isActive())
				throw new CustomException("Trainer with Id: " + trainer.getTrainerId()
						+ " is already present and active.");
			else {
				temp.setActive(true);
				manager.getTransaction().commit();
				throw new CustomException(
						"Trainer with Id: " + trainer.getTrainerId() + " is already present and has been set active.");
			}
		} else {
			manager.persist(trainer);
			manager.getTransaction().commit();
			return true;
		}
	}

	@Override
	public boolean removeTrainer(String trainerId) throws CustomException {

		if(!manager.getTransaction().isActive())manager.getTransaction().begin();
		TrainerDTO temp = manager.find(TrainerDTO.class, trainerId);
		
		if (temp!=null && temp.isActive()) {
			temp.setActive(false);
			manager.getTransaction().commit();
			return true;
		} else {
			throw new CustomException("Trainer with Id: " + trainerId + "is not active, so cannot be removed!");
		}

	}

	@Override
	public boolean addTrainerSkill(String skill, String trainerId) throws CustomException {
		if(!manager.getTransaction().isActive())manager.getTransaction().begin();
		TrainerDTO temp = manager.find(TrainerDTO.class, trainerId);
		if(temp==null)
			throw new CustomException("Trainer with Id: " + trainerId + "is not present!");
		String skillDB = temp.getSkills();
		List<String> skills = Arrays.asList(skillDB.split(","));
		if (skills.contains(skill)) {
			throw new CustomException("Skill aready exists");
		} else {
			if(skills.size()==1 && skills.get(0).length()==0)
					temp.setSkills(skill);
			else temp.setSkills(skillDB+","+skill);
			manager.getTransaction().commit();
			return true;
		}
	}

	@Override
	public boolean removeTrainerSkill(String skillName, String trainerId) throws CustomException {
		if(!manager.getTransaction().isActive())manager.getTransaction().begin();
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
		if(flag) {
			Optional<String> opt = skills.stream().filter(skill->!skill.equals(skillName)).reduce((skill1,skill2) -> skill1+","+skill2);
			if(opt.isPresent())
				temp.setSkills(opt.get());
			else temp.setSkills("");
			manager.getTransaction().commit();
		} else
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
	
	@Override
	public String getProgramFromTrainer(String batchId, String trainerId) {
		Query query = manager.createQuery("From TrainerProgramDTO where batch='"+batchId+"' and trainerid='"+trainerId+"'",TrainerProgramDTO.class);
		TrainerProgramDTO temp;
		try {
			temp = (TrainerProgramDTO) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		return temp.getProgramId();
	}
	
	@Override
	public List<String> getAvailableTrainers(String batchId) {
		List<String> activeTrainers = getTrainers();
		Query query1 = manager.createQuery("From ProgramCourseDTO",ProgramCourseDTO.class);
		Stream<ProgramCourseDTO> stream = ((List<ProgramCourseDTO>)query1.getResultList()).stream().filter(temp->LocalDate.parse(temp.getStartdate()).isBefore(LocalDate.now()) && LocalDate.parse(temp.getEnddate()).isAfter(LocalDate.now()));		
		if(stream.count()==0) return activeTrainers;
		else {
			Query query2 = manager.createQuery("From TrainerProgramDTO where batch='"+batchId+"' and programid IN :param",TrainerProgramDTO.class);
			query2.setParameter("param", stream.map(temp->temp.getProgramId()).collect(Collectors.toList()));
			List<String> trainersBusy = ((List<TrainerProgramDTO>)query1.getResultList()).stream().map(temp->temp.getTrainerId()).collect(Collectors.toList());
			if(trainersBusy.size()==0) return activeTrainers;
			return activeTrainers.stream().filter(temp-> !trainersBusy.contains(temp)).collect(Collectors.toList());
		}
	}
}
