package com.cg.feedback.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.feedback.dto.StudentDTO;

public class StaticDB {
	private static Map<String, StudentDTO> studentList=new HashMap<>();
	
	static{
		studentList.put("Stu12", new StudentDTO("Stu12", "Shubham", "Shubham@124", "shubh98ban@gmail.com"));
		studentList.put("Stu11", new StudentDTO("Stu11", "Shivam", "Shivam@13", "shivam.singh@gmail.com"));
		studentList.put("Stu15", new StudentDTO("Stu15", "Asshish", "Ashu$13", "ashubh9@yahoo.in"));
	}

	public static Map<String, StudentDTO> getStudentList() {
		return studentList;
	}

	public static void setStudentList(Map<String, StudentDTO> studentList) {
		StaticDB.studentList = studentList;
	}
	
	
	

}
