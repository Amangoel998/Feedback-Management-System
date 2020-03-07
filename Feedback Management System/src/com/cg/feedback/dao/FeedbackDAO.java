package com.cg.feedback.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cg.feedback.dto.CourseDTO;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.QuestionsSetDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.exceptions.CustomException;

public interface FeedbackDAO {
	List<FeedbackDTO> viewFeedback(ProgramDAO program) throws CustomException;
	List<FeedbackDTO> viewFeedback(TrainerDTO trainer) throws CustomException;
	List<StudentDTO> viewFeedbackDefaulters(ProgramDAO program) throws CustomException;
	boolean giveFeedback(FeedbackDTO feedbackSet) throws CustomException;
}
