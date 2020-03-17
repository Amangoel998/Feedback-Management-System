package com.cg.feedback.service;

import java.util.List;

import com.cg.feedback.dao.FeedbackDAO;
import com.cg.feedback.dao.FeedbackDAOImpl;
import com.cg.feedback.dao.StudentDAO;
import com.cg.feedback.dao.StudentDAOImpl;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.QuestionsSetDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.exceptions.CustomException;

public class StudentServiceImpl{
	/*
	private static StudentDTO student=null;
	
	private static FeedbackDAO fdb = new FeedbackDAOImpl();
	@Override
	public boolean login(String id, String pass) throws CustomException {
		if(student != null)
			return false;
		else {
//			student = ;
			return true;
		}
	}

	@Override
	public boolean logout() throws CustomException {
		if(student == null)return true;
		else {
			student = null;
			return false;
		}
	}
	public static List<FeedbackDTO> avaiableFeedbacks(){
	for(Stirng programId: student.getPrograms()){
		If(fdb.viewStudentFeedback(programId, studemnt.id) == null){
			
		}
	}
	}
	@Override
	public boolean giveFeedback(QuestionsSetDTO questionSet) throws CustomException {
		FeedbackDTO feedbackSet = new FeedbackDTO();
		return fdb.giveFeedback(feedbackSet);
	}
	*/
}
