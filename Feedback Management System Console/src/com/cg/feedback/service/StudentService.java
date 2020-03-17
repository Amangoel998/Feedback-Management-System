<<<<<<< HEAD:Feedback Management System Console/src/com/cg/feedback/service/StudentService.java
package com.cg.feedback.service;

import java.util.List;

import com.cg.feedback.dto.QuestionsSetDTO;
import com.cg.feedback.exceptions.CustomException;

public interface StudentService extends UserService{
	List<String> getProgramsEnrolled() throws CustomException;
	boolean giveFeedback(QuestionsSetDTO questionSet, String programID) throws CustomException;
}
=======
package com.cg.feedback.service;

import java.util.List;

import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.exceptions.CustomException;

public interface StudentService extends UserService{
	List<String> getProgramsEnrolled() throws CustomException;
	FeedbackDTO giveFeedback(FeedbackDTO feedbackSet) throws CustomException;
}
>>>>>>> f1464cfd9260bfbb1bf2cabd5579c30419673198:Feedback Management System Console/src/com/cg/feedback/service/StudentService.java
