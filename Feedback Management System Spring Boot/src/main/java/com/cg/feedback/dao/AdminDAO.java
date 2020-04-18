package com.cg.feedback.dao;

import java.util.List;

import com.cg.feedback.dto.AdminDTO;
import com.cg.feedback.dto.BatchCourseDTO;
import com.cg.feedback.dto.ProgramCourseDTO;
import com.cg.feedback.dto.TrainerProgramDTO;
import com.cg.feedback.exceptions.CustomException;

public interface AdminDAO {
	AdminDTO validateAdmin(String id, String pass) throws CustomException;
	boolean addPrograminCourse(ProgramCourseDTO programs) throws CustomException;
	List<String> availableBatches() throws CustomException;
	boolean assignTrainertoProgram(TrainerProgramDTO trainer) throws CustomException;
	boolean assignCourseToBatch(BatchCourseDTO batches) throws CustomException;
}
