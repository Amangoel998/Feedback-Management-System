package com.cg.feedback.pl;

import static com.cg.feedback.utility.Input.*;
import static com.cg.feedback.pl.UserInterface.*;
import com.cg.feedback.dto.QuestionsSetDTO;
import com.cg.feedback.service.*;



public class AuthInterface {
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
				((AdminServiceImpl)user).getAdminMethods(method);
				break;
			case 2:
				getTrainerOptions();
				method = inputTrainerOptions("Admin Options");
				((TrainerServiceImpl)user).getTrainerMethods(method);
				break;
			case 3:
				System.out.println("Give Feedback for trainings");
				QuestionsSetDTO feedbackSet = takeQuestions();
				((StudentServiceImpl) user).giveFeedback(feedbackSet);
				break;
			default:
				break;
			}
		}while(!logout());
	}

}
