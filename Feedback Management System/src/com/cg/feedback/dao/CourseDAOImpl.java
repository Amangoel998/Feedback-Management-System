package com.cg.feedback.dao;

import com.cg.feedback.dto.CourseDTO;
import com.cg.feedback.exceptions.CustomException;

public class CourseDAOImpl {
	/*
	private static StaticDAO dao = new StaticDAO();
	@Override
	public boolean addTrainingCourse(CourseDTO course) throws CustomException {
		if(dao.getCourses().containsKey(course.getCourseId())){
			CourseDTO temp = dao.getCourses().get(course.getCourseId());
			if(temp.isActive())
				throw new CustomException("Course with ID: "+course.getCourseId()+" is already present and active. First delete the existing course to overwrite.");
			else{
				temp.setActive(true);
				throw new CustomException("Course with ID: "+course.getCourseId()+" is already present and has been set active.");
			}
		};
		dao.getCourses().put(course.getCourseId(),course);
		return true;
	}

	@Override
	public boolean removeTrainingCourse(String courseId) throws CustomException {
		if(dao.getCourses().containsKey(courseId) && dao.getCourses().get(courseId).isActive()){
			dao.getCourses().get(courseId).setActive(false);
			return true;
		}
		throw new CustomException("Course with Id: "+courseId+" is not active, so cannot be removed.");
	}
	*/
}
