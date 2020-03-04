package com.cg.feedback.pl;
import static com.cg.feedback.utility.Input.*;

import com.cg.feedback.dto.QuestionsSetDTO;

public class UserInterface {
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
	static void getAdminOptions(){
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
	}
	static int getTrainerOptions(){
		System.out.println("1. View Feedback Report\n"
				+ "2. View Feedback Defaulters\n");
		return inputTrainerOptions("Trainer Options");
	}
	static void showWelcome(){
		System.out.println("WELCOME to FeedBack Management System!\n\n");
	}
	
}
