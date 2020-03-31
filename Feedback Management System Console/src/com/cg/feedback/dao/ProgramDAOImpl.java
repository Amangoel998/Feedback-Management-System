
package com.cg.feedback.dao;

import java.util.List;
import java.util.stream.Collectors;

import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.exceptions.CustomException;

public class ProgramDAOImpl implements ProgramDAO {
	private static StaticDAO dao = new StaticDAO();

	@Override
	public boolean addTrainingProgram(ProgramDTO program) throws CustomException {
		if (dao.getCourses().containsKey(program.getProgramId())) {
			ProgramDTO temp = dao.getPrograms().get(program.getProgramId());
			if (temp.isActive())
				throw new CustomException("Program with ID: " + program.getProgramId()
						+ " is already present and active. First delete the existing program to overwrite.");
			else {
				temp.setActive(true);
				throw new CustomException(
						"Program with ID: " + program.getProgramId() + " is already present and has been set active.");
			}
		}
		;
		dao.getPrograms().put(program.getProgramId(), program);
		return true;
	}

	@Override
	public boolean removeTrainingProgram(String programId) throws CustomException {
		if (dao.getPrograms().containsKey(programId)) {
			dao.getPrograms().get(programId).setActive(false);
			return true;
		}
		throw new CustomException("Program with Id: " + programId + " is not active, so cannot be removed");
	}

	@Override
	public ProgramDTO getProgram(String programId) throws CustomException {
		ProgramDTO temp = dao.getProgram(programId);
		if (temp != null)
			return temp;
		throw new CustomException("Program Exception : No Program with ID = " + programId + "!");
	}

	@Override
	public List<String> getPrograms() throws CustomException {
		return dao.getPrograms().values().stream().filter(temp->temp.isActive()).map(temp->temp.getProgramId()+"-"+temp.getProgramName()).collect(Collectors.toList());
	}
}