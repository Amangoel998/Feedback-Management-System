package com.cg.feedback.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;

import com.cg.feedback.dto.AdminDTO;
import com.cg.feedback.dto.BatchCourseDTO;
import com.cg.feedback.dto.ProgramCourseDTO;
import com.cg.feedback.dto.TrainerProgramDTO;
import com.cg.feedback.exceptions.CustomException;
import com.cg.feedback.id.ProgramCourseDTOId;
import com.cg.feedback.id.TrainerProgramDTOId;

public class AdminDAOImpl implements AdminDAO {
	static EntityManager manager = JPAUtil.getEntityManagerFactory().createEntityManager();
	@Override
	public boolean validateAdmin(String id, String pass) throws CustomException {
		AdminDTO temp = manager.find(AdminDTO.class, id);
		if(temp!=null) {
			if(temp.getAdminPass().equals(pass))
				return true;
		}
		return false;
	}

	@Override
	public boolean assignCourseToBatch(BatchCourseDTO batches) throws CustomException {
		if(!manager.getTransaction().isActive())manager.getTransaction().begin();
		try {
			manager.persist(batches);
		} catch (EntityExistsException e) {
			manager.find(BatchCourseDTO.class, batches.getBatch()).setCourseId(batches.getCourseId());
			manager.getTransaction().commit();
			throw new CustomException("batch Already Exists so overwritten!");
		}
		manager.getTransaction().commit();
		return true;
	}

	@Override
	public boolean addPrograminCourse(ProgramCourseDTO programs) throws CustomException {
		if(!manager.getTransaction().isActive())manager.getTransaction().begin();
		ProgramCourseDTO temp = manager.find(ProgramCourseDTO.class, new ProgramCourseDTOId(programs.getProgramId(), programs.getCourseId()));
		if(temp == null) {
			manager.persist(programs);
		} else {
			temp.setEnddate(programs.getEnddate());
			temp.setStartdate(programs.getStartdate());
			System.out.println("Program-Course Already Exists so overwritten!");
		}
		manager.getTransaction().commit();
		return true;
	}

	@Override
	public boolean assignTrainertoProgram(TrainerProgramDTO trainer) throws CustomException {
		if(!manager.getTransaction().isActive())manager.getTransaction().begin();
		try {
			manager.persist(trainer);
		} catch (EntityExistsException e) {
			TrainerProgramDTO temp = manager.find(TrainerProgramDTO.class, new TrainerProgramDTOId(trainer.getBatch(),trainer.getProgramId()));
			temp.setTrainerId(trainer.getTrainerId());
			manager.getTransaction().commit();
			throw new CustomException("Trainer for Program in this Batch Already Exists so overwritten!");
		}
		manager.getTransaction().commit();
		return true;
	}

	@Override
	public List<String> availableBatches() throws CustomException {
		EntityManager manager = JPAUtil.getEntityManagerFactory().createEntityManager();
		List<String> result = manager.createQuery("from BatchCourseDTO",BatchCourseDTO.class).getResultList().stream().map(temp->temp.getBatch()).collect(Collectors.toList());
		return result;
	}

}
