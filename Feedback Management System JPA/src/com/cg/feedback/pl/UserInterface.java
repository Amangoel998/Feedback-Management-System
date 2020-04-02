package com.cg.feedback.pl;

import java.util.List;
import static com.cg.feedback.utility.Input.*;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.QuestionsSetDTO;

public class UserInterface {
	static void showRole() {
		System.out.println("Select the role you want to login with:" + "\n1.Admin" + "\n2.Trainer" + "\n3.Student");
	}

	static QuestionsSetDTO takeQuestions() {
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

	public static FeedbackDTO takeFeedback(List<FeedbackDTO> feedbacks) {
		System.out.println("Available Feedbacks for the following programs along with their trainers :");
		int i = 1;
		for (FeedbackDTO temp : feedbacks) {
			System.out.println((i++) + temp.getProgramId() + "\tBy\t" + temp.getTrainerId());
		}
		System.out.print("Which Program you would like to give feedback for ?\nEnter a number from 1 to " + (i-1) + ":");
		int e = inputInt("", i);
		FeedbackDTO feedback = feedbacks.get(e);
		System.out.println("Entering Feedback for the program " + feedback.getProgramId() + " by "
				+ feedback.getTrainerId() + " :");
		feedback.setQuestions(takeQuestions());
		feedback.setComments(inputComments());
		feedback.setSuggestions(inputSuggestion());
		return feedback;
	}

	static void showLikeliness() {
		System.out.println("Following are the rating you could choose for each question"
				+ "5: Excellent: 	'Ideal way of doing it'\n"
				+ "4: Good:			'No pain areas or concern but could have been better'\n"
				+ "3: Average:		'There are concerns but not significant'\n"
				+ "2: Below Average:	'Needs improvement and is salvageable'\n"
				+ "1: Poor: 			'This way of doing things must change'\n");
	}

	static void getAdminOptions() {
		System.out.println("1. Add Training Program\n" + "2. Delete Training Program\n" + "3. Add Students\n"
				+ "4. Remove Students\n" + "5. Add Trainer\n" + "6. Remove Trainer\n" + "7. Add Skillset of Trainer\n"
				+ "8. Remove Trainer Skills\n" + "9. Add Training Course\n" + "10. Delete Training Course\n"
				+ "11. View Feedback Report by Program\n" + "12. View Feedback Report by Trainer\n"
				+ "13. View Feedback Defaulters by Program\n" + "14. View Feedback Defaulters by Trainer\n"
				+ "15. Assign Course to a Batch\n" + "16. Assign Trainer to a Program\n");
	}

	static void getTrainerOptions() {
		System.out.println("1. View Feedback Report\n" + "2. View Feedback Defaulters\n");
	}

	static void showWelcome() {
		System.out.println("WELCOME to FeedBack Management System!\n\n");
	}

}
