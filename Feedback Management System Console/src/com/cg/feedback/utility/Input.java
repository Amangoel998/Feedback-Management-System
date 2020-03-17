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

public class Input{
	static Scanner sc = new Scanner(System.in);
	
	public static int inputRole(String s){
		int i;
		while(true){
			try{
				System.out.print("Enter "+s+": ");
				i = sc.nextInt();
				if(i>0&&i<4)
					return i;
				else throw new Exception();
			}catch(Exception e){
				System.err.print("Invalid "+s+", enter again");
				sc.nextLine();
			}
		}
	}
	public static int inputAdminOptions(String s){
		int i;
		while(true){
			try{
				System.out.print("Enter "+s+": ");
				Thread.sleep(1000);
				i = sc.nextInt();
				if(i>0&&i<13)
					return i;
				else throw new Exception();
			}catch(Exception e){
				System.err.print("Invalid "+s+", enter again");
				sc.nextLine();
			}
		}
	}
	public static int inputTrainerOptions(String s){
		int i;
		while(true){
			try{
				System.out.print("Enter "+s+": ");
				Thread.sleep(1000);
				i = sc.nextInt();
				if(i>0&&i<3)
					return i;
				else throw new Exception();
			}catch(Exception e){
				System.err.print("Invalid "+s+", enter again");
				sc.nextLine();
			}
		}
	}
	public static int inputRating(){
		int id;
		while(true){
			try{
				Thread.sleep(1000);
				id = sc.nextInt();
				if(id>0 && id<6)
					return id;
				else throw new Exception();
			}catch(Exception e){
				System.err.print("Invalid Rating, enter again");
				sc.nextLine();
			}
		}
	}
	public static String[] inputCredentials(int role){
		String[] st = new String[2];
		String pt;
		pt=(role==1)?"Admin":(role==2)?"Trainer":"Student";
		sc.nextLine();
		while(true){
			try{
				System.out.print("\nEnter "+pt+" ID: ");
				st[0] = sc.nextLine();
				System.out.print("\nEnter Password: ");
				st[1] = sc.nextLine();
				if(isValidPassword(st[1])){
					if((role==1)?isValidAdminId(st[0]):(role==2)?isValidTrainerId(st[0]):isValidStudentId(st[0]))
						return st;
					else throw new CustomException("Invalid Credentials");
				}
				else throw new CustomException("Invalid Credentials");
			}catch(CustomException e){
				System.err.print(e.getMessage());
				sc.nextLine();
			}
		}
	}

	public static String inputYesOrNo(){
		while(true){
			try{
				System.out.print("\nInput (Y/N):");
				String s = sc.next();
				if("Y".equals(s) || "N".equals(s)||"y".equals(s) || "n".equals(s))
					return s;
				else
					throw new Exception();
			}catch(Exception e){
				System.err.print("Invalid Input");
			}
		}
	}
	public static ProgramDTO inputProgram(){
		return null;
	}
	public static StudentDTO inputStudent(){
		return null;
	}
	public static TrainerDTO inputTrainer(){
		return null;
	}
	public static CourseDTO inputCourse(){
		return null;
	}
	public static String inputProgramId(){
		return "";
	}
	public static String inputCourseId(){
		return "";
	}
	public static String inputStudentId(){
		return "";
	}
	public static String inputTrainerId(){
		return "";
	}
	public static String inputSkill(){
		return "";
	}
	public static String inputComments(){
		System.out.println("Any Comments : ");
		return sc.nextLine();
	}
	public static String inputSuggestion(){
		System.out.print("Any Suggestions : ");
		return sc.nextLine();
	}
	
	public static String inputPhone(String s){
		String st;
		while(true){
			try{
				System.out.print("\nEnter "+s+": ");
				st = sc.next();
				if(Validator.isValidPhone(st))
					return st;
				else throw new Exception();
			}catch(Exception e){
				System.err.print("Invalid "+s+", enter again");
			}
		}
	}
	public static String inputEmail(String s){
		String st;
		while(true){
			try{
				System.out.println("\nEnter "+s+": ");
				st = sc.next();
				if(Validator.isValidEmail(st))
					return st;
				else throw new Exception();
			}catch(Exception e){
				System.out.print("Invalid "+s+", enter again");
			}
		}
	}
	public static LocalDate inputDate(String s){
		System.out.println("Enter "+s+": ");
		while(true){
			try{
				System.err.print("\nEnter Year Month Day");
				int d = sc.nextInt(), m = sc.nextInt(), y = sc.nextInt();
				LocalDate ld = LocalDate.of(y, m, d);
				return ld;
			}catch(DateTimeException | CustomException e){
				System.out.print("Invalid "+s+", enter again: ");
			}
		}
	}
	public static float inputFloat(String s){
		float f;
		while(true){
			try{
				System.out.println("Enter "+s+": ");
				f = sc.nextFloat();
				return f;
			}catch(InputMismatchException | CustomException e){
				System.out.print("Invalid "+s+", enter again: ");
			}
		}
	}
	public static int inputQuantity(String s){
		int f;
		while(true){
			try{
				System.out.print("Enter "+s+": ");
				f = sc.nextInt();
				if(Validator.isValidQuantity(f))
					return f;
			}catch(InputMismatchException | CustomException e){
				System.out.print("Invalid "+s+", enter again");
			}
		}
	}
	
	public static int inputInt(String s){
		int f;
		while(true){
			try{
				System.out.println("Enter "+s+": ");
				f = sc.nextInt();
				return f;
			}catch(InputMismatchException | CustomException e){
				System.out.print("Invalid "+s+", enter again");
			}
		}
	}
}