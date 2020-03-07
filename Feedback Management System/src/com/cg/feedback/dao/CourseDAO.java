package com.cg.feedback.dao;

import com.cg.feedback.exceptions.CustomException;

public interface CourseDAO {
	void addTrainingCourse() throws CustomException;
	void removeTrainingCourse() throws CustomException;
}
