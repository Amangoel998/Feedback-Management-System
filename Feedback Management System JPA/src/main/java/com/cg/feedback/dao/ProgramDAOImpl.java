package com.cg.feedback.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;


import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.dto.TrainerProgramDTO;
import com.cg.feedback.exceptions.CustomException;

public class ProgramDAOImpl implements ProgramDAO{

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Feedback Management System JPA");
	private EntityManager manager = emf.createEntityManager();
	
	@Override
	public boolean addTrainingProgram(ProgramDTO program) throws CustomException {
		if(!manager.getTransaction().isActive())manager.getTransaction().begin();
		ProgramDTO temp = manager.find(ProgramDTO.class, program.getProgramId());
		if(temp!=null){
				throw new CustomException("Program with ID: "+program.getProgramId()+" is already present. First delete the existing program to overwrite.");
		};
		manager.persist(program);
		manager.getTransaction().commit();
		return true;
	}

	@Override
	public boolean removeTrainingProgram(String programId) throws CustomException {
		if(!manager.getTransaction().isActive())manager.getTransaction().begin();
		ProgramDTO program = manager.find(ProgramDTO.class, programId);
		if(program!=null){
			manager.remove(program);
			manager.getTransaction().commit();
			return true;
		}
		throw new CustomException("Program with Id: "+programId+"is not present, so cannot be removed");
	}

	@Override
	public ProgramDTO getProgram(String programId) throws CustomException {
		ProgramDTO temp = manager.find(ProgramDTO.class,programId);
		if(temp!=null)
			return temp;
		throw new CustomException("Program Exception : No Program with ID = "+programId+"!");
	}
	
	@Override
	public List<String> getPrograms() throws CustomException{
		return manager.createQuery("from ProgramDTO",ProgramDTO.class).getResultList().stream().map(temp->temp.getProgramId()+"-"+temp.getProgramName()).collect(Collectors.toList());
	}

	@Override
	public List<String> availablePrograms(String batch) {
		List<String> programs = manager.createQuery("from TrainerProgramDTO where batch='"+batch+"'",TrainerProgramDTO.class).getResultList().stream().map(temp->temp.getProgramId()).collect(Collectors.toList());
		return getPrograms().stream().filter(temp->!programs.contains(temp)).collect(Collectors.toList());
	}
}
