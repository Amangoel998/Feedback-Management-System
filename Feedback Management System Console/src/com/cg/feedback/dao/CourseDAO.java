package com.cg.feedback.dao;

import com.cg.feedback.dto.CourseDTO;
import com.cg.feedback.exceptions.CustomException;

public interface CourseDAO {
	boolean addTrainingCourse(CourseDTO course) throws CustomException;
	boolean removeTrainingCourse(String courseId) throws CustomException;
	CourseDTO getCourse(String courseId) throws CustomException;
}
