package com.cg.feedback.repository.dao;

import java.util.List;

import com.cg.feedback.repository.dto.CourseDTO;
import com.cg.feedback.repository.exceptions.CustomException;

public interface CourseDAO {
	boolean addTrainingCourse(CourseDTO course) throws CustomException;
	boolean removeTrainingCourse(String courseId) throws CustomException;
	CourseDTO getCourse(String courseId) throws CustomException;
	List<String> getCourses() throws CustomException;
}
