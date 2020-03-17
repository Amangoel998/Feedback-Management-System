<<<<<<< HEAD:Feedback Management System Console/src/com/cg/feedback/dao/FeedbackDAO.java
package com.cg.feedback.dao;

import java.util.List;

import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.exceptions.CustomException;

public interface FeedbackDAO {
	List<StudentDTO> viewFeedbackDefaulters(String programId) throws CustomException;
	
	FeedbackDTO giveFeedback(FeedbackDTO feedbackSet) throws CustomException;
	List<FeedbackDTO> viewFeedbackByProgram(ProgramDTO program) throws CustomException;
	List<FeedbackDTO> viewFeedbackByTrainer(TrainerDTO trainer) throws CustomException;
}
=======
package com.cg.feedback.dao;

import java.util.List;

import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.exceptions.CustomException;

public interface FeedbackDAO {
	List<StudentDTO> viewFeedbackDefaultersByProgram(String programId) throws CustomException;
	List<StudentDTO> viewFeedbackDefaultersByTrainer(String trainerId) throws CustomException;
	
	FeedbackDTO giveFeedback(FeedbackDTO feedbackSet) throws CustomException;
	List<FeedbackDTO> viewFeedbackByProgram(String programId) throws CustomException;
	List<FeedbackDTO> viewFeedbackByTrainer(String trainerId) throws CustomException;
}
>>>>>>> f1464cfd9260bfbb1bf2cabd5579c30419673198:Feedback Management System Console/src/com/cg/feedback/dao/FeedbackDAO.java
