package com.cg.feedback.repository.dao;

import java.util.List;

import com.cg.feedback.repository.dto.BatchCourseDTO;
import com.cg.feedback.repository.dto.ProgramCourseDTO;
import com.cg.feedback.repository.dto.TrainerProgramDTO;
import com.cg.feedback.repository.exceptions.CustomException;

public interface AdminDAO {
	boolean validateAdmin(String id, String pass) throws CustomException;
	boolean addPrograminCourse(ProgramCourseDTO programs) throws CustomException;
	List<String> availableBatches() throws CustomException;
	boolean assignTrainertoProgram(TrainerProgramDTO trainer) throws CustomException;
	boolean assignCourseToBatch(BatchCourseDTO batches) throws CustomException;
}
