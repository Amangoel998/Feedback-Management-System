package com.cg.feedback.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.exceptions.CustomException;

public class TrainerDAOImpl implements TrainerDAO {
	StaticDAO staticDb = new StaticDAO();

	@Override
	public TrainerDTO getTrainer(String trainerId) throws CustomException {
		TrainerDTO trainer = staticDb.getTrainers().get(trainerId);
		if (trainer != null)
			return trainer;
		else
			throw new CustomException("Trainer with Id: " + trainerId + " not present");
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
			throw new CustomException("Trainer with Id: " + trainerId + " is not active, so cannot be removed");
		}

	}

	@Override
	public boolean addTrainerSkill(String skill, String trainerId) throws CustomException {
		TrainerDTO trn = staticDb.getTrainers().get(trainerId);
		List<String> skills = trn.getSkills();
		if (skills != null && skills.contains(skill)) {
			throw new CustomException("Skill aready exists");
		} else {
			trn.addSkill(skill);
			return true;
		}
	}

	@Override
	public boolean removeTrainerSkill(String skillName, String trainerId) throws CustomException {
		List<String> skills = staticDb.getTrainers().get(trainerId).getSkills();
		for (int i = 0; i < skills.size(); i++) {
			if (skills.get(i).equals(skillName)) {
				skills.remove(i);
				return true;
			}
		}
		throw new CustomException("Skill not present in Trainer Skill-set.");
	}

	@Override
	public boolean validateTrainer(String trainerId, String pass) throws CustomException {
		if (getTrainer(trainerId).getTrainerPass().equals(pass))
			return true;
		return false;
	}

	@Override
	public String getTrainerFromProgram(String batchId, String programsId) {
		Optional<String> trainer = staticDb.getListOfTrainerProgram().values().stream()
				.filter(temp1 -> temp1.get(1) == programsId && temp1.get(2) == batchId).map(temp1 -> temp1.get(0))
				.findFirst();
		if (trainer.isPresent())
			return trainer.get();
		return null;
	}

	@Override
	public List<String> getTrainers() {
		return staticDb.getTrainers().values().stream().filter(temp->temp.isActive()).map(temp -> temp.getTrainerId()+"-"+temp.getTrainerName()).collect(Collectors.toList());
	}

	@Override
	public List<String> getAvailableTrainers(String batchId) {
		List<String> activeTrainers = getTrainers();
		Stream<List<String>> stream = staticDb.getListOfProgramInCourse().values().stream().filter(temp->LocalDate.parse(temp.get(2)).isBefore(LocalDate.now()) && LocalDate.parse(temp.get(3)).isAfter(LocalDate.now()));		
		if(stream.count()==0) return activeTrainers;
		else {
			List<String> trainersBusy = staticDb.getListOfTrainerProgram().values().stream().filter(temp-> {
				return stream.map(temp1->temp1.get(1)).collect(Collectors.toList()).contains(temp.get(1)) && temp.get(2).equals(batchId);
			}).map(temp -> temp.get(0)).collect(Collectors.toList());
			if(trainersBusy.size()==0) return activeTrainers;
			return activeTrainers.stream().filter(temp-> !trainersBusy.contains(temp)).collect(Collectors.toList());
		}
	}
}
