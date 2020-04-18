package com.cg.feedback.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cg.feedback.exceptions.CustomException;

public class AdminDAOImpl implements AdminDAO {
	
	private StaticDAO dao = new StaticDAO();
	int flag = -1;
	int i = -1;
	@Override
	public boolean addPrograminCourse(List<String> programs) {
		flag = -1;
		i = -1;
		Map<Integer,List<String>> temp = dao.getListOfProgramInCourse();
		temp.values().stream().forEach(temp1 -> {
			i++;
			if(temp1.get(0).equals(programs.get(0)) && temp1.get(1).equals(programs.get(1))) {
				flag=i;
			}
		});
		if(flag==-1) {
			dao.getListOfProgramInCourse().put(i+1,programs);
			return true;
		}
		dao.getListOfProgramInCourse().put(flag, programs);
		throw new CustomException("Program-Course Already Exists so overwritten!");
	}

	@Override
	public List<String> availableBatches() {
		return dao.getBatchOfCourse().keySet().stream().collect(Collectors.toList());
	}

	@Override
	public boolean assignTrainertoProgram(List<String> trainer) {
		flag = -1;
		i = -1;
		Map<Integer,List<String>> temp = dao.getListOfTrainerProgram();
		temp.values().stream().forEach(temp1 -> {
			i++;
			if(temp1.get(2).equals(trainer.get(2)) && temp1.get(1).equals(trainer.get(1))) {
				flag=i;
			}
		});
		if(flag==-1) {
			dao.getListOfProgramInCourse().put(i+1,trainer);
			return true;
		}
		dao.getListOfProgramInCourse().put(flag, trainer);
		throw new CustomException("Trainer for Program in this Batch Already Exists so overwritten!");
	}

	@Override
	public boolean assignCourseToBatch(List<String> batches) {
		flag = -1;
		i = -1;
		Map<String,String> temp = dao.getBatchOfCourse();
		if(!temp.containsKey(batches.get(0))) {
			temp.put(batches.get(0),batches.get(1));
			return true;
		}
		temp.put(batches.get(0),batches.get(1));
		throw new CustomException("Program-Course Already Exists so overwritten!");
	}

}
