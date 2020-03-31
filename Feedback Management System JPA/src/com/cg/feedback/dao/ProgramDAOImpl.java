package com.cg.feedback.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.exceptions.CustomException;

@Repository
public class ProgramDAOImpl implements ProgramDAO{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public boolean addTrainingProgram(ProgramDTO program) throws CustomException {
		ProgramDTO temp = manager.find(ProgramDTO.class, program.getProgramId());
		if(temp!=null){
			if(temp.isActive())
				throw new CustomException("Program with ID: "+program.getProgramId()+" is already present and active. First delete the existing program to overwrite.");
			else{
				temp.setActive(true);
				throw new CustomException("Program with ID: "+program.getProgramId()+" is already present and has been set active.");
			}
		};
		manager.persist(program);
		return true;
	}

	@Override
	public boolean removeTrainingProgram(String programId) throws CustomException {
		ProgramDTO program = manager.find(ProgramDTO.class, programId);
		if(program!=null && program.isActive()){
			program.setActive(false);
			return true;
		}
		throw new CustomException("Program with Id: "+programId+"is not active, so cannot be removed");
	}

	@Override
	public ProgramDTO getProgram(String programId) throws CustomException {
		ProgramDTO temp = manager.find(ProgramDTO.class,programId);
		if(temp!=null)
			return temp;
		throw new CustomException("Program Exception : No Program with ID = "+programId+"!");
	}
}
