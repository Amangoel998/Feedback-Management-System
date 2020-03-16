package com.cg.feedback.pl;

import static com.cg.feedback.utility.Input.*;

import java.util.List;
import java.util.Scanner;

import static com.cg.feedback.pl.UserInterface.*;

import com.cg.feedback.dto.AdminDTO;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.QuestionsSetDTO;
import com.cg.feedback.service.*;
import com.sun.corba.se.spi.ior.iiop.GIOPVersion;

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
		if("Y".equals(inputYesOrNo())){
			user = null;
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		showWelcome();
		showRole();
		Scanner sc = new Scanner(System.in);
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
				method = inputTrainerOptions("Admin Options");
				((TrainerServiceImpl)user).getTrainerMethods(method,ad[0]);
				break;
			case 3:
				List<FeedbackDTO> feedbacks = ((StudentServiceImpl)user).availableFeedbacks(ad[0]);
				System.out.println("Available Feedbacks for the following programs along with their trainers :");
				int i=1;
				for(FeedbackDTO temp : feedbacks){
					System.out.println((i++)+temp.getProgramId()+"\tBy\t"+temp.getTrainerId());
				}
				System.out.println("Which Program you would like to give feedback for ? ||Enter a number from 1 to "+i+"||");
				int e = Integer.parseInt(sc.nextLine());
				FeedbackDTO temp = feedbacks.get(e);
				System.out.println("Entering Feedback for the program "+temp.getProgramId()+" by "+temp.getTrainerId()+" :");
				temp.setQuestions(takeQuestions());
				System.out.println("Any Comments : ");
				temp.setComments(sc.nextLine());
				System.out.println("Any Suggestions : ");
				temp.setSuggestions(sc.nextLine());
				
				break;
			default:
				break;
			}
		}while(!logout());
	}
}
