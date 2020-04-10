package com.cg.feedback.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.feedback.dto.CourseDTO;
import com.cg.feedback.exceptions.CustomException;

public class CourseDAOImpl implements CourseDAO{

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Feedback Management System JPA");
	private EntityManager manager = emf.createEntityManager();
	
	@Override
	public boolean addTrainingCourse(CourseDTO course) throws CustomException {
		if(!manager.getTransaction().isActive())manager.getTransaction().begin();
		CourseDTO temp = manager.find(CourseDTO.class, course.getCourseId());
		if(temp!=null){
			if(temp.isActive())
				throw new CustomException("Course Exception : Course with ID: "+course.getCourseId()+" is already present and active. First delete the existing course to overwrite.");
			else{
				temp.setActive(true);
				manager.getTransaction().commit();
				throw new CustomException("Course Exception : Course with ID: "+course.getCourseId()+" is already present and has been set active.");
			}
		};
		manager.persist(course);
		manager.getTransaction().commit();
		return true;
	}

	@Override
	public boolean removeTrainingCourse(String courseId) throws CustomException {
		if(!manager.getTransaction().isActive())manager.getTransaction().begin();
		CourseDTO temp = manager.find(CourseDTO.class, courseId);
		if(temp!=null && temp.isActive()){
			temp.setActive(false);
			manager.getTransaction().commit();
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

	@Override
	public List<String> getCourses() throws CustomException {
		return manager.createQuery("from CourseDTO where isactive=1",CourseDTO.class).getResultList().stream().map(temp->temp.getCourseId()+"-"+temp.getCourseName()).collect(Collectors.toList());
	}
	
}
