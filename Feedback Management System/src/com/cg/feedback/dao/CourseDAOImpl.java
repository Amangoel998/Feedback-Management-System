package com.cg.feedback.dao;

import com.cg.feedback.dto.CourseDTO;
import com.cg.feedback.exceptions.CustomException;

public class CourseDAOImpl implements CourseDAO {
	private static StaticDAO dao = new StaticDAO();
	@Override
	public boolean addTrainingCourse(CourseDTO course) throws CustomException {
		if(dao.getCourses().containsKey(course.getCourseId())){
			throw new CustomException(course.getCourseId()+" is already present. First delete the existing record to overwrite.");
		};
		dao.getCourses().put(course.getCourseId(),course);
		return true;
	}

	@Override
	public boolean removeTrainingCourse(String courseId) throws CustomException {
		if(dao.getCourses().containsKey(courseId)){
			dao.getCourses().remove(courseId);
			return true;
		}
		throw new CustomException(courseId+" is not present, so cannot be deleted.");
	}

}
