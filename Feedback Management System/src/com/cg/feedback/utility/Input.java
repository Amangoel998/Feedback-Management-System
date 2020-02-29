package com.cg.feedback.utility;

import java.time.LocalDate;
import java.util.Scanner;

import com.cg.feedback.exceptions.CustomException;

public class Input{
	static Scanner sc = new Scanner(System.in);
	
	public static int inputRole(String s){
		int i;
		while(true){
			try{
				System.out.println("Enter "+s+": ");
				Thread.sleep(1000);
				i = sc.nextInt();
				if(i>0&&i<4)
					return i;
				else throw new Exception();
			}catch(Exception e){
				System.err.println("Invalid "+s+", enter again");
				sc.nextLine();
			}
		}
	}
	public static int inputAdminOptions(String s){
		int i;
		while(true){
			try{
				System.out.println("Enter "+s+": ");
				Thread.sleep(1000);
				i = sc.nextInt();
				if(i>0&&i<13)
					return i;
				else throw new Exception();
			}catch(Exception e){
				System.err.println("Invalid "+s+", enter again");
				sc.nextLine();
			}
		}
	}
	public static int inputTrainerOptions(String s){
		int i;
		while(true){
			try{
				System.out.println("Enter "+s+": ");
				Thread.sleep(1000);
				i = sc.nextInt();
				if(i>0&&i<3)
					return i;
				else throw new Exception();
			}catch(Exception e){
				System.err.println("Invalid "+s+", enter again");
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
				System.err.println("Invalid Rating, enter again");
				sc.nextLine();
			}
		}
	}
	public static int inputMobileId(String s){
		int id;
		while(true){
			try{
				System.out.println("Enter "+s+": ");
				Thread.sleep(1000);
				id = sc.nextInt();
				if(Validator.isValidId(id))
					return id;
				else throw new Exception();
			}catch(Exception e){
				System.err.println("Invalid "+s+", enter again");
				sc.nextLine();
			}
		}
	}
	public static String inputName(String s){
		String st;
		sc.nextLine();
		while(true){
			try{
				System.out.println("Enter "+s+": ");
				st = sc.nextLine();
				if(Validator.isValidName(st))
					return st;
				else throw new Exception();
			}catch(Exception e){
				System.err.println("Invalid, enter again");
			}
		}
	}
	public static String inputPhone(String s){
		String st;
		while(true){
			try{
				System.out.println("Enter "+s+": ");
				st = sc.next();
				if(Validator.isValidPhone(st))
					return st;
				else throw new Exception();
			}catch(Exception e){
				System.err.println("Invalid "+s+", enter again");
			}
		}
	}
	public static String inputEmail(String s){
		String st;
		while(true){
			try{
				System.out.println("Enter "+s+": ");
				st = sc.next();
				if(Validator.isValidEmail(st))
					return st;
				else throw new Exception();
			}catch(Exception e){
				System.out.println("Invalid "+s+", enter again");
			}
		}
	}
	public static LocalDate inputDate(String s){
		System.out.println("Enter "+s+": ");
		while(true){
			try{
				System.err.println("Enter Year Month Day");
				int d = sc.nextInt(), m = sc.nextInt(), y = sc.nextInt();
				LocalDate ld = LocalDate.of(y, m, d);
				return ld;
			}catch(Exception e){
				System.out.println("Invalid "+s+", enter again: ");
			}
		}
	}
	public static float inputPrice(String s){
		float f;
		while(true){
			try{
				System.out.println("Enter "+s+": ");
				f = sc.nextFloat();
				return f;
			}catch(CustomException e){
				System.out.println("Invalid "+s+", enter again: ");
			}
		}
	}
	public static int inputQuantity(String s){
		int f;
		while(true){
			try{
				System.out.println("Enter "+s+": ");
				f = sc.nextInt();
				if(Validator.isValidQuantity(f))
					return f;
			}catch(CustomException e){
				System.out.println("Invalid "+s+", enter again");
			}
		}
	}
}