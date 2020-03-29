package com.cg.feedback.utility;

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

	public static int inputRole(String s) {
		int i;
		while (true) {
			try {
				System.out.print("\nEnter " + s + ": ");
				i = sc.nextInt();
				if (i > 0 && i < 4)
					return i;
				else
					throw new CustomException("Invalid " + s + ", enter again");
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
				i = sc.nextInt();
				if (i > 0 && i < 13)
					return i;
				else
					throw new CustomException("Invalid " + s + ", enter again");
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
				i = sc.nextInt();
				if (i > 0 && i < 3)
					return i;
				else
					throw new CustomException("Invalid " + s + ", enter again");
			} catch (CustomException e) {
				System.err.print(e.getMessage());
			}
		}
	}

	public static int inputRating() {
		int id;
		while (true) {
			try {
				id = sc.nextInt();
				if (id > 0 && id < 6)
					return id;
				else
					throw new CustomException("Invalid Rating, enter again");
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
		while (true) {
			try {
				System.out.print("\nInput (Y/N):");
				String s = sc.next();
				if ("Y".equals(s) || "N".equals(s) || "y".equals(s) || "n".equals(s))
					return s;
				else
					throw new CustomException("Invalid Input");
			} catch (CustomException e) {
				System.err.print(e.getMessage());
			}
		}
	}

	public static ProgramDTO inputProgram() {
		return new ProgramDTO(inputProgramId(), inputName("Program Name"));
	}

	public static StudentDTO inputStudent() {
		return new StudentDTO(inputStudentId(), inputName("Student Name"), inputPassword(), inputEmail(), inputBatch());
	}

	public static TrainerDTO inputTrainer() {
		return new TrainerDTO(inputTrainerId(), inputName("Trainer Name"), inputPassword(), inputEmail());
	}

	public static CourseDTO inputCourse() {
		return new CourseDTO(inputCourseId(), inputName("Course Name"));
	}

	public static String inputProgramId() {
		String st;
		while (true) {
			try {
				System.out.print("\nEnter Program ID: ");
				st = sc.next();
				if (Validator.isValidProgramId(st))
					return st;
			} catch (CustomException e) {
				System.err.print(e.getMessage() + ", enter again");
			}
		}
	}

	public static String inputCourseId() {
		String st;
		while (true) {
			try {
				System.out.print("\nEnter Program ID: ");
				st = sc.next();
				if (Validator.isValidCourseId(st))
					return st;
			} catch (CustomException e) {
				System.err.print(e.getMessage() + ", enter again");
			}
		}
	}

	public static String inputStudentId() {
		String st;
		while (true) {
			try {
				System.out.print("\nEnter Program ID: ");
				st = sc.next();
				if (Validator.isValidStudentId(st))
					return st;
			} catch (CustomException e) {
				System.err.print(e.getMessage() + ", enter again");
			}
		}
	}

	public static String inputTrainerId() {
		String st;
		while (true) {
			try {
				System.out.print("\nEnter Trainer ID: ");
				st = sc.next();
				if (Validator.isValidTrainerId(st))
					return st;
			} catch (CustomException e) {
				System.err.print(e.getMessage() + ", enter again");
			}
		}
	}

	public static String inputSkill() {
		return inputName("Skill Name");
	}

	public static String inputComments() {
		System.out.println("Any Comments : ");
		return sc.nextLine();
	}

	public static String inputSuggestion() {
		System.out.print("Any Suggestions : ");
		return sc.nextLine();
	}

	public static String inputBatch() {
		String st;
		while (true) {
			try {
				System.out.print("\nEnter Batch: ");
				st = sc.next();
				if (Validator.isValidBatch(st))
					return st;
			} catch (CustomException e) {
				System.err.print(e.getMessage() + " enter again");
			}
		}
	}

	public static String inputName(String s) {
		String st;
		while (true) {
			try {
				System.out.print("\nEnter " + s + ": ");
				st = sc.nextLine();
				if (Validator.isValidName(st))
					return st;
			} catch (CustomException e) {
				System.err.print("Invalid " + s + ", should be [Xxxx Xxxx] enter again");
			}
		}
	}

	public static String inputPassword() {
		String st;
		while (true) {
			try {
				System.out.print("\nEnter Password: ");
				st = sc.next();
				if (Validator.isValidPassword(st))
					return st;
			} catch (CustomException e) {
				System.err.print(e.getMessage() + ", enter again");
			}
		}
	}

	public static String inputUserId(int role) {
		String st, pt;
		pt = (role == 1) ? "Admin" : (role == 2) ? "Trainer" : "Student";
		while (true) {
			try {
				System.out.print("\nEnter " + pt + " ID: ");
				st = sc.next();
				if ((role == 1) ? isValidAdminId(st) : (role == 2) ? isValidTrainerId(st) : isValidStudentId(st))
					return st;
			} catch (CustomException e) {
				System.err.print(e.getMessage() + ", enter again");
			}
		}
	}

	public static String inputPhone(String s) {
		String st;
		while (true) {
			try {
				System.out.print("\nEnter " + s + ": ");
				st = sc.next();
				if (Validator.isValidPhone(st))
					return st;
			} catch (CustomException e) {
				System.err.print("Invalid " + s + ", enter again");
			}
		}
	}

	public static String inputEmail() {
		String st;
		while (true) {
			try {
				System.out.println("\nEnter Email: ");
				st = sc.next();
				if (Validator.isValidEmail(st))
					return st;
				else
					throw new Exception();
			} catch (Exception e) {
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

	public static float inputFloat(String s) {
		float f;
		while (true) {
			try {
				System.out.println("Enter " + s + ": ");
				f = sc.nextFloat();
				return f;
			} catch (InputMismatchException | CustomException e) {
				System.out.print("Invalid " + s + ", enter again: ");
			}
		}
	}

	public static int inputQuantity(String s) {
		int f;
		while (true) {
			try {
				System.out.print("Enter " + s + ": ");
				f = sc.nextInt();
				if (Validator.isValidQuantity(f))
					return f;
			} catch (InputMismatchException | CustomException e) {
				System.out.print("Invalid " + s + ", enter again");
			}
		}
	}

	public static int inputInt(String s) {
		int f;
		while (true) {
			try {
				System.out.println("Enter " + s + ": ");
				f = sc.nextInt();
				return f;
			} catch (InputMismatchException | CustomException e) {
				System.out.print("Invalid " + s + ", enter again");
			}
		}
	}
}