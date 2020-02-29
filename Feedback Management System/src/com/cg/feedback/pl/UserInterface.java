package com.cg.feedback.pl;
import static com.cg.feedback.utility.Input.*;

import com.cg.feedback.dto.QuestionsSetDTO;
import com.cg.feedback.service.*;

public class UserInterface {
	static AdminService adm;
	static StudentService std;
	static TrainerService trn;
	static void showRole(){
		System.out.println("Select the role you want to login with:\n"
				+ "1.Admin\n"
				+ "2.Trainer\n"
				+ "3.Student\n");
	}
	static QuestionsSetDTO takeQuestions(){
		showLikeliness();
		System.out.println("Questions for feedback: ");
		System.out.println("Presentation and communication skills of faculty: ");
		int q1 = inputRating();
		System.out.println("Ability to clarify doubts and explain difficult points: ");
		int q2 = inputRating();
		System.out.println("Time management in completing the contents: ");
		int q3 = inputRating();
		System.out.println("Handout provided(Student Guide): ");
		int q4 = inputRating();
		System.out.println("Hardware, software and network availability: ");
		int q5 = inputRating();
		return new QuestionsSetDTO(q1, q2, q3, q4, q5);
	}
	static void showLikeliness(){
		System.out.println("Following are the rating you could choose for each question"
				+ "5: Excellent: 'Ideal way of doing it'\n"
				+ "4:	Good:			'No pain areas or concern but could have been better'\n"
				+ "3:	Average:		'There are concerns but not significant'\n"
				+ "2:	Below Average:	'Needs improvement and is salvageable'\n"
				+ "1:	Poor: 			'This way of doing things must change'\n");		
	}
	static int getAdminOptions(){
		System.out.println("1. Add Training Course\n"
				+ "2. Delete Training Course\n"
				+ "3. Add Students\n"
				+ "4. Remove Students\n"
				+ "5. Add Trainer\n"
				+ "6. Remove Trainer\n"
				+ "7. Maintain Skillset of Trainer\n"
				+ "8. Update Training Program\n"
				+ "9. Add Training Program\n"
				+ "10. Delete Training Program\n"
				+ "11. View Feedback Report\n"
				+ "12. View Feedback Defaulters\n");
		return inputAdminOptions("Admin Options");
	}
	static int getTrainerOptions(){
		System.out.println("1. View Feedback Report\n"
				+ "2. View Feedback Defaulters\n");
		return inputTrainerOptions("Trainer Options");
	}
	static void showMenu(){
		System.out.println("WELCOME to FeedBack Management System!\n\n");
	}
	public static void main(String[] args) {
		showMenu();
		showRole();
		int role = inputRole("Role Options");
		do{
			int method;
			if(role==1){
				adm = (AdminService) new AdminServiceImpl();
				String[] ad = inputCredentials(role);
				if(adm.login(ad[0], ad[1]))
					System.out.println("Invalid Credentials");
				method = getAdminOptions();
				switch(method){
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					break;
				case 11:
					break;
				case 12:
					break;
				default:
					adm.logout();
					break;
				}
			}else if(role==2){
				trn = (TrainerService) new TrainerServiceImpl();
				String[] ad = inputCredentials(role);
				if(trn.login(ad[0], ad[1]))
					System.out.println("Invalid Credentials");
				method = getTrainerOptions();
				if(method==1){
					
				}else if(method==2){
					
				}
				else{
					trn.logout();
				}
			}else{
				System.out.println("Give Feedback for trainings");
				std = (StudentService) new StudentServiceImpl();
				String[] ad = inputCredentials(role);
				if(std.login(ad[0], ad[1]))
					System.out.println("Invalid Credentials");
				QuestionsSetDTO feedbackSet = takeQuestions();
				std.giveFeedback(feedbackSet);
			}
		}while(true);
	}

}
