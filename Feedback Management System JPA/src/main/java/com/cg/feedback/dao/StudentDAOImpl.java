package com.cg.feedback.dao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import com.cg.feedback.dto.BatchCourseDTO;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.LoginDTO;
import com.cg.feedback.dto.ProgramCourseDTO;
import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.exceptions.CustomException;
import static com.cg.feedback.utility.GeneratePassKey.generatePass;

public class StudentDAOImpl implements StudentDAO{

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Feedback Management System JPA");
	private EntityManager manager = emf.createEntityManager();
	
	private TrainerDAO trainerDAO = new TrainerDAOImpl();
	private ProgramDAO programDAO = new ProgramDAOImpl();
	
	@Override
	public StudentDTO getStudent(String studentId) throws CustomException {
		
		StudentDTO student = manager.find(StudentDTO.class, studentId);
		if (student != null)
			return student;
		else
			throw new CustomException("Student with Id: " + studentId + " not present");
	}
	
	@Override
	public List<String> getStudents() throws CustomException {
		return manager.createQuery("from StudentDTO where isactive=1",StudentDTO.class).getResultList().stream().map(temp->temp.getStudentId()+"-"+temp.getStudentName()).collect(Collectors.toList());
	}
	
	@Override
	public boolean addStudents(StudentDTO student) throws CustomException {

		if(!manager.getTransaction().isActive())manager.getTransaction().begin();
		StudentDTO temp = manager.find(StudentDTO.class, student.getStudentId());
		if(temp!=null) {
				throw new CustomException("Student Exception : Student with Id: "+student.getStudentId()+" already exists.");
		}
		else{
			manager.persist(new LoginDTO(student.getStudentId(), generatePass(student.getStudentName(), student.getStudentId()) , "student"));
			manager.persist(student);
			manager.getTransaction().commit();
			return true;
		}
	}
	@Override
	public List<String> getAvailablePrograms(String course) throws CustomException {
		Query query2 = manager.createQuery("from ProgramCourseDTO where courseid='"+course+"'",ProgramCourseDTO.class);
		List<ProgramCourseDTO> res2 = query2.getResultList();
		return res2.stream().filter(temp -> {
			long days = ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.parse(temp.getEnddate()));
			if(days<=0 && days>=-30)
				return true;
			return false;
		}).map(temp -> temp.getProgramId()).collect(Collectors.toList());
	}
	
	@Override
	public Map<String, FeedbackDTO> getAvailableFeedbacks(String studentId) throws CustomException{
		StudentDTO student = manager.find(StudentDTO.class, studentId);
		Query query1 = manager.createQuery("from BatchCourseDTO where batch='"+student.getBatch()+"'", BatchCourseDTO.class);
		BatchCourseDTO res1 = (BatchCourseDTO) query1.getSingleResult();
		String tempBatch = student.getBatch();
		String tempCourse = res1.getCourseId();
		List<String> programs = getAvailablePrograms(tempCourse);
		programs.stream().forEach(temp->System.out.println(temp));
		if(programs.size()==0) throw new CustomException("Student Exception : Student with Id: "+studentId+" has not completed a program since last 30 days!");
		Map<String,FeedbackDTO> feedbacks = new HashMap<String,FeedbackDTO>();
		List<String> feedbackGiven = new ArrayList<String>();
		Long feedbackId = ((FeedbackDTO)manager.createQuery("from FeedbackDTO order by feedbackid desc").setMaxResults(1).getSingleResult()).getFeedbackId()+1;
		Query query2 = manager.createQuery("from FeedbackDTO where studentid='"+studentId+"' and programid IN :param",FeedbackDTO.class);
		query2.setParameter("param",programs);
		((List<FeedbackDTO>)query2.getResultList()).stream().map(temp->temp.getProgramId()).forEach(temp->feedbackGiven.add(temp));
		programs.stream().filter(temp -> !feedbackGiven.contains(temp)).forEach(temp -> {
			FeedbackDTO ftemp = new FeedbackDTO();
			ftemp.setFeedbackId(feedbackId);
			ftemp.setProgramId(temp);
			ftemp.setStudentId(studentId);
			String prgTrn = temp+"("+programDAO.getProgram(temp).getProgramName()+") By ";
			String trainer = trainerDAO.getTrainerFromProgram(tempBatch, temp);
			if(trainer!=null){
				ftemp.setTrainerId(trainer);
				prgTrn += trainer+"("+trainerDAO.getTrainer(trainer).getTrainerName()+")";
				feedbacks.put(prgTrn,ftemp);
			}
		});
		return feedbacks;
	}

	@Override
	public boolean removeStudent(String studentId) throws CustomException {
		if(!manager.getTransaction().isActive())manager.getTransaction().begin();
		StudentDTO student = manager.find(StudentDTO.class, studentId);
		if(student!=null) {
			manager.remove(manager.find(LoginDTO.class, studentId));
			manager.remove(student);
			manager.getTransaction().commit();
			return true;
		}
		else
			throw new CustomException("Student with Id: "+studentId+" does not exist, so cannot be removed");
	}


	@Override
	public boolean validateStudent(String studentId, String pass) throws CustomException {
		StudentDTO student = manager.find(StudentDTO.class, studentId);
		if(student!=null) {
			if(manager.find(LoginDTO.class, studentId).getUserPass().equals(pass))
				return true;
		}
		return false;
	}
	
}
