package com.cg.feedback.dao;

import java.util.List;

public interface AdminDAO {

	boolean addPrograminCourse(List<String> programs);

	List<String> availableBatches();

	boolean assignTrainertoProgram(List<String> trainer);

	boolean assignCourseToBatch(List<String> batches);

}
