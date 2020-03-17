<<<<<<< HEAD:Feedback Management System Console/src/com/cg/feedback/dao/ProgramDAO.java
package com.cg.feedback.dao;

import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.exceptions.CustomException;

public interface ProgramDAO {
	boolean addTrainingProgram(ProgramDTO program)  throws CustomException;
	boolean removeTrainingProgram(String programId)  throws CustomException;

	ProgramDTO getProgram(String programId) throws CustomException;
	
}
=======
package com.cg.feedback.dao;

import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.exceptions.CustomException;

public interface ProgramDAO {
	boolean addTrainingProgram(ProgramDTO program)  throws CustomException;
	boolean removeTrainingProgram(String programId)  throws CustomException;
	ProgramDTO getProgram(String programId) throws CustomException;
	
}
>>>>>>> f1464cfd9260bfbb1bf2cabd5579c30419673198:Feedback Management System Console/src/com/cg/feedback/dao/ProgramDAO.java
