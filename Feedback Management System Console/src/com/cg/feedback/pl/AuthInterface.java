<<<<<<< HEAD:Feedback Management System Console/src/com/cg/feedback/pl/AuthInterface.java
package com.cg.feedback.pl;

import static com.cg.feedback.utility.Input.*;
import static com.cg.feedback.pl.UserInterface.*;
import com.cg.feedback.dto.QuestionsSetDTO;
import com.cg.feedback.service.*;

public class AuthInterface {
	/*
	private static UserService user;
	private static boolean login(int role){
		switch(role){
		case 1:
			user =  new AdminServiceImpl();
			break;
		case 2:
			user = new TrainerServiceImpl();
			break;
		case 3:
			user = new StudentServiceImpl();
			break;
		default:
			user = null;
			break;
		}
		String[] ad = inputCredentials(role);
		if(!user.login(ad[0], ad[1])){
			System.out.println("Invalid Credentials");
			return false;
		}
		return true;
	}
	
	private static boolean logout(){
		System.out.println("Do you want to logout?");
		if("Y".equals(inputYesOrNo())){
			user = null;
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		showWelcome();
		showRole();
		int role = inputRole("Role Options");
		while(!login(role));
		do{
			int method = 0;
			switch(role){
			case 1:
				getAdminOptions();
				method = inputAdminOptions("Admin Options");
//				((AdminServiceImpl)user).getAdminMethods(method);
				break;
			case 2:
				getTrainerOptions();
				method = inputTrainerOptions("Admin Options");
				((TrainerServiceImpl)user).getTrainerMethods(method);
				break;
			case 3:
				System.out.println("Give Feedback for trainings");
				QuestionsSetDTO questionSet = takeQuestions();
				((StudentServiceImpl) user).giveFeedback(questionSet);
				break;
			default:
				break;
			}
		}while(!logout());
	}
	*/
}
=======
package com.cg.feedback.pl;

import static com.cg.feedback.utility.Input.*;

import java.util.List;
import java.util.Scanner;

import static com.cg.feedback.pl.UserInterface.*;

import com.cg.feedback.dto.AdminDTO;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.QuestionsSetDTO;
import com.cg.feedback.service.*;

public class AuthInterface {
	private static Object user;
	private static String[] ad = null;
	private static boolean login(int role){
		ad = inputCredentials(role);
		switch(role){
		case 1:
			user =  new AdminServiceImpl();
			if(!((AdminService)user).login(ad[0], ad[1])){
				System.out.println("Invalid Credentials");
				return false;
			}
			break;
		case 2:
			user = new TrainerServiceImpl();
			if(!((TrainerServiceImpl)user).login(ad[0], ad[1])){
				System.out.println("Invalid Credentials");
				return false;
			}
			break;
		case 3:
			user = new StudentServiceImpl();
			if(!((StudentServiceImpl)user).login(ad[0], ad[1])){
				System.out.println("Invalid Credentials");
				return false;
			}
			break;
		default:
			user = null;
			break;
		}
		
		return true;
	}
	
	public static boolean logout(){
		System.out.println("Do you want to logout?");
		String yon = inputYesOrNo();
		if("Y".equals(yon)||"y".equals(yon)){
			user = null;
			System.out.println("Thank You!");
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		showWelcome();
		showRole();
		int role = inputRole("Role Options");
		while(!login(role));
		do{
			int method = 0;
			switch(role){
			case 1:
				getAdminOptions();
				method = inputAdminOptions("Admin Options");
				AdminInterface.getAdminMethods(method);
				break;
			case 2:
				getTrainerOptions();
				method = inputTrainerOptions("Trainer Options");
				((TrainerServiceImpl)user).getTrainerMethods(method);
				break;
			case 3:
				List<FeedbackDTO> feedbacks = ((StudentServiceImpl)user).availableFeedbacks();
				takeFeedback(feedbacks);
				break;
			default:
				break;
			}
		}while(!logout());
	}
}
>>>>>>> f1464cfd9260bfbb1bf2cabd5579c30419673198:Feedback Management System Console/src/com/cg/feedback/pl/AuthInterface.java
