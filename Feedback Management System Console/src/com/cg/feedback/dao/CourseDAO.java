<<<<<<< HEAD:Feedback Management System Console/src/com/cg/feedback/dao/CourseDAO.java
package com.cg.feedback.dao;

import com.cg.feedback.dto.CourseDTO;
import com.cg.feedback.exceptions.CustomException;

public interface CourseDAO {
	boolean addTrainingCourse(CourseDTO course) throws CustomException;
	boolean removeTrainingCourse(String courseId) throws CustomException;
	
	CourseDTO getCourse(String courseId) throws CustomException;
}
=======
package com.cg.feedback.dao;

import com.cg.feedback.dto.CourseDTO;
import com.cg.feedback.exceptions.CustomException;

public interface CourseDAO {
	boolean addTrainingCourse(CourseDTO course) throws CustomException;
	boolean removeTrainingCourse(String courseId) throws CustomException;
	CourseDTO getCourse(String courseId) throws CustomException;
}
>>>>>>> f1464cfd9260bfbb1bf2cabd5579c30419673198:Feedback Management System Console/src/com/cg/feedback/dao/CourseDAO.java
