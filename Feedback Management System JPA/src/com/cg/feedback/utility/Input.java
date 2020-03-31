package com.cg.feedback.utility;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import static com.cg.feedback.utility.Validator.*;

import com.cg.feedback.dto.CourseDTO;
import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.exceptions.CustomException;

public class Input {
	static Scanner sc = new Scanner(System.in);
	static InputStreamReader inr = new InputStreamReader(System.in);
	static BufferedReader br;
	static Console cons;

	public static int inputRole(String s) {
		int i;
		while (true) {
			try {
				System.out.print("\nEnter " + s + ": ");
				if (sc.hasNextInt()) {
					i = sc.nextInt();
					if (i > 0 && i < 4)
						return i;
					else
						throw new CustomException("Invalid " + s + ", enter again");
				} else {
					throw new CustomException("Invalid " + s + ", enter again");
				}
			} catch (CustomException e) {
				System.err.print(e.getMessage());
			}
		}
	}

	public static int inputInt(String s, int ed) {
		int i;
		while (true) {
			try {
				System.out.print("\nEnter " + s + ": ");
				if (sc.hasNextInt()) {
					i = sc.nextInt();
					if (i > 0 && i < ed)
						return i;
					else
						throw new CustomException("Invalid " + s + ", enter again");
				} else {
					throw new CustomException("Invalid " + s + ", enter again");
				}
			} catch (CustomException e) {
				System.err.print(e.getMessage());
			}
		}
	}

	public static int inputAdminOptions(String s) {
		int i;
		while (true) {
			try {
				System.out.print("\nEnter " + s + ": ");
				if (sc.hasNextInt()) {
					i = sc.nextInt();
					if (i > 0 && i < 15)
						return i;
					else
						throw new CustomException("Invalid " + s + ", enter again");
				} else {
					throw new CustomException("Invalid " + s + ", enter again");
				}

			} catch (CustomException e) {
				System.err.print(e.getMessage());
			}
		}
	}

	public static int inputTrainerOptions(String s) {
		int i;
		while (true) {
			try {
				System.out.print("\nEnter " + s + ": ");
				if (sc.hasNextInt()) {
					i = sc.nextInt();
					if (i > 0 && i < 3)
						return i;
					else
						throw new CustomException("Invalid " + s + ", enter again");
				} else {
					throw new CustomException("Invalid " + s + ", enter again");
				}
			} catch (CustomException e) {
				System.err.print(e.getMessage());
			}
		}
	}

	public static int inputRating() {
		int id;
		while (true) {
			try {
				if (sc.hasNextInt()) {
					id = sc.nextInt();
					if (id > 0 && id < 6)
						return id;
					else
						throw new CustomException("Invalid Rating, enter again");
				} else {
					throw new CustomException("Invalid Rating, enter again");
				}
			} catch (CustomException e) {
				System.err.print(e.getMessage());
			}
		}
	}

	public static String[] inputCredentials(int role) {
		String[] st = new String[2];
		while (true) {
			try {
				st[0] = inputUserId(role);
				st[1] = inputPassword();
				return st;
			} catch (CustomException e) {
				System.err.print("Invalid Credentials");
			}
		}
	}

	public static String inputYesOrNo() {
		br = new BufferedReader(inr);
		String s;
		while (true) {
			try {
				System.out.print("\nInput (Y/N):");
				s = br.readLine();
				if ("Y".equals(s) || "N".equals(s) || "y".equals(s) || "n".equals(s)) {

					return s;
				} else
					throw new CustomException("Invalid Input\n");
			} catch (IOException | CustomException e) {
				System.err.print(e.getMessage());
			}
		}
	}

	public static ProgramDTO inputProgram() {
		return new ProgramDTO(inputProgramId(), inputName("Program Name"), true);
	}

	public static StudentDTO inputStudent() {
		return new StudentDTO(inputStudentId(), inputName("Student Name"), inputPassword(), inputEmail(), inputBatch(), true);
	}

	public static TrainerDTO inputTrainer() {
		return new TrainerDTO(inputTrainerId(), inputName("Trainer Name"), "", inputPassword(), inputEmail(), true);
	}

	public static CourseDTO inputCourse() {
		return new CourseDTO(inputCourseId(), inputName("Course Name"), true);
	}

	public static String inputProgramId() {
		String st;
		br = new BufferedReader(inr);
		while (true) {
			try {
				System.out.print("\nEnter Program ID: ");
				st = br.readLine();
				if (Validator.isValidProgramId(st)) {

					return st;
				}
			} catch (IOException | CustomException e) {
				System.err.print(e.getMessage() + ", enter again");
			}
		}
	}

	public static String inputCourseId() {
		String st;
		br = new BufferedReader(inr);
		while (true) {
			try {
				System.out.print("\nEnter Course ID: ");
				st = br.readLine();
				if (Validator.isValidCourseId(st)) {

					return st;
				}
			} catch (IOException | CustomException e) {
				System.err.print(e.getMessage() + ", enter again");
			}
		}
	}

	public static String inputStudentId() {
		String st;
		br = new BufferedReader(inr);
		while (true) {
			try {
				System.out.print("\nEnter Student ID: ");
				st = br.readLine();
				if (Validator.isValidStudentId(st)) {

					return st;
				}
			} catch (IOException | CustomException e) {
				System.err.print(e.getMessage() + ", enter again");
			}
		}
	}

	public static String inputTrainerId() {
		String st;
		br = new BufferedReader(inr);
		while (true) {
			try {
				System.out.print("\nEnter Trainer ID: ");
				st = br.readLine();
				if (Validator.isValidTrainerId(st)) {

					return st;
				}
			} catch (IOException | CustomException e) {
				System.err.print(e.getMessage() + ", enter again");
			}
		}
	}

	public static String inputSkill() {
		return inputName("Skill Name");
	}

	public static String inputComments() {
		System.out.println("Any Comments : ");
		br = new BufferedReader(inr);
		try {
			String comment = br.readLine();

			return comment;
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return "";
		}
	}

	public static String inputSuggestion() {
		System.out.print("Any Suggestions : ");
		br = new BufferedReader(inr);
		try {
			String comment = br.readLine();

			return comment;
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return "";
		}
	}

	public static String inputBatch() {
		String st;
		br = new BufferedReader(inr);
		while (true) {
			try {
				System.out.print("\nEnter Batch: ");
				st = br.readLine();
				if (Validator.isValidBatch(st)) {

					return st;
				}
			} catch (IOException | CustomException e) {
				System.err.print(e.getMessage() + " enter again");
			}
		}
	}

	public static String inputName(String s) {
		String st;
		br = new BufferedReader(inr);
		while (true) {
			try {
				System.out.print("\nEnter " + s + ": ");
				st = br.readLine();
				if (Validator.isValidName(st)) {

					return st;
				}
			} catch (IOException | CustomException e) {
				System.err.print("Invalid " + s + ", should be [Xxxx Xxxx] enter again");
			}
		}
	}

	public static String inputPassword() {
		String st;
		br = new BufferedReader(inr);
		while (true) {
			try {
				System.out.print("\nEnter Password: {hidden}");
				st = br.readLine();
				if (Validator.isValidPassword(st)) {
					return st;
				}
			} catch (IOException | CustomException e) {
				System.err.print(e.getMessage() + ", enter again");
			} 
		}
	}

	public static String inputUserId(int role) {
		String st, pt;
		br = new BufferedReader(inr);
		pt = (role == 1) ? "Admin" : (role == 2) ? "Trainer" : "Student";
		while (true) {
			try {
				System.out.print("\nEnter " + pt + " ID: ");
				st = br.readLine();
				if ((role == 1) ? isValidAdminId(st) : (role == 2) ? isValidTrainerId(st) : isValidStudentId(st)) {

					return st;
				}
			} catch (IOException | CustomException e) {
				System.err.print(e.getMessage() + ", enter again");
			}
		}
	}

	public static String inputEmail() {
		String st;
		br = new BufferedReader(inr);
		while (true) {
			try {
				System.out.println("\nEnter Email: ");
				st = br.readLine();
				if (Validator.isValidEmail(st)) {

					return st;
				}
			} catch (IOException | CustomException e) {
				System.out.print("Invalid email, enter again");
			}
		}
	}

	public static LocalDate inputDate() {
		System.out.println("Enter Date: ");
		while (true) {
			try {
				System.err.print("\nEnter Year Month Day");
				int d = sc.nextInt(), m = sc.nextInt(), y = sc.nextInt();
				LocalDate ld = LocalDate.of(y, m, d);
				return ld;
			} catch (DateTimeException | CustomException e) {
				System.out.print("Invalid date, enter again: ");
			}
		}
	}
}