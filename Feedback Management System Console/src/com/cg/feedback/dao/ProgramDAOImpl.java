package com.cg.feedback.dao;

import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.exceptions.CustomException;

public class ProgramDAOImpl{
	/*
	private static StaticDAO dao = new StaticDAO();
	@Override
	public boolean addTrainingProgram(ProgramDTO program) throws CustomException {
		if(dao.getCourses().containsKey(program.getProgramId())){
			ProgramDTO temp = dao.getPrograms().get(program.getProgramId());
			if(temp.isActive())
				throw new CustomException("Program with ID: "+program.getProgramId()+" is already present and active. First delete the existing program to overwrite.");
			else{
				temp.setActive(true);
				throw new CustomException("Program with ID: "+program.getProgramId()+" is already present and has been set active.");
			}
		};
		dao.getPrograms().put(program.getProgramId(),program);
		return true;
	}

	@Override
	public boolean removeTrainingProgram(String programId) throws CustomException {
		if(dao.getPrograms().containsKey(programId)){
			dao.getPrograms().get(programId).setActive(false);
			return true;
		}
		throw new CustomException("Program with Id: "+programId+"is not active, so cannot be removed");
	}
	*/
}