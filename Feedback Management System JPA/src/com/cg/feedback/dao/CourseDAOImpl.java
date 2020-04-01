package com.cg.feedback.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.feedback.dto.CourseDTO;
import com.cg.feedback.exceptions.CustomException;

@Repository
public class CourseDAOImpl implements CourseDAO{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public boolean addTrainingCourse(CourseDTO course) throws CustomException {
		CourseDTO temp = manager.find(CourseDTO.class, course.getCourseId());
		if(temp!=null){
			if(temp.isActive())
				throw new CustomException("Course Exception : Course with ID: "+course.getCourseId()+" is already present and active. First delete the existing course to overwrite.");
			else{
				temp.setActive(true);
				throw new CustomException("Course Exception : Course with ID: "+course.getCourseId()+" is already present and has been set active.");
			}
		};
		manager.persist(course);
		return true;
	}

	@Override
	public boolean removeTrainingCourse(String courseId) throws CustomException {
		CourseDTO temp = manager.find(CourseDTO.class, courseId);
		if(temp!=null && temp.isActive()){
			temp.setActive(false);
			return true;
		}
		throw new CustomException("Course Exception : Course with Id: "+courseId+" is not active, so cannot be removed.");
	}

	@Override
	public CourseDTO getCourse(String courseId) throws CustomException {
		CourseDTO temp = manager.find(CourseDTO.class, courseId);
		if(temp!=null)
			return temp;
		throw new CustomException("Course Exception : No Course with ID = "+courseId+"!");
	}
}
