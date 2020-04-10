package com.cg.feedback.pl;

import static com.cg.feedback.utility.Input.*;
import static com.cg.feedback.pl.UserInterface.*;
import com.cg.feedback.service.*;

import java.util.List;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.exceptions.CustomException;

public class AuthInterface {
	private static Object user;
	private static String[] ad = null;

	private static void login(int role) {
		boolean res = false;
		while (!res) {
			try {
				ad = inputCredentials(role);
				switch (role) {
					case 1:
						user = new AdminServiceImpl();
						if (!((AdminService) user).login(ad[0], ad[1])) {
							System.out.println("Invalid Credentials");
							res = false;
						}
						else res=true;
						break;
					case 2:
						user = new TrainerServiceImpl();
						if (!((TrainerServiceImpl) user).login(ad[0], ad[1])) {
							System.out.println("Invalid Credentials");
							res = false;
						}
						else res=true;
						break;
					case 3:
						user = new StudentServiceImpl();
						if (!((StudentServiceImpl) user).login(ad[0], ad[1])) {
							System.out.println("Invalid Credentials");
							res = false;
						}
						else res=true;
						break;
					default:
						user = null;
						break;
				}
			} catch (CustomException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static boolean logout() {
		System.out.println("Do you want to logout?");
		String yon = inputYesOrNo();
		if ("Y".equals(yon) || "y".equals(yon)) {
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
		login(role);
		do {
			try {
				int method = 0;
				switch (role) {
					case 1:
						getAdminOptions();
						method = inputAdminOptions("Admin Options");
						AdminInterface.getAdminMethods(method);
						break;
					case 2:
						getTrainerOptions();
						method = inputTrainerOptions("Trainer Options");
						System.out.println(((TrainerServiceImpl) user).getTrainerMethods(method));
						break;
					case 3:
						List<FeedbackDTO> feedbacks = ((StudentServiceImpl) user).availableFeedbacks();
						takeFeedback(feedbacks);
						break;
					default:
						break;
				}
			} catch (CustomException e) {
				System.out.println(e.getMessage());
			}
		} while (!logout());
	}
}
