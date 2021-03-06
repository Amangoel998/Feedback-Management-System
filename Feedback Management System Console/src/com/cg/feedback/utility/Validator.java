package com.cg.feedback.utility;

import com.cg.feedback.exceptions.*;
import java.util.regex.Pattern;

public class Validator {

	public static boolean isValidAdminId(String name) throws CustomException {
		if (!Pattern.matches("^(ADM)[0-9]{3,}$", name))
			throw new CustomException("Invalid Admin ID");
		return true;
	}

	public static boolean isValidTrainerId(String name) throws CustomException {
		if (!Pattern.matches("^(TRN)[0-9]{3,}$", name))
			throw new CustomException("Invalid Trainer ID");
		return true;
	}

	public static boolean isValidStudentId(String name) throws CustomException {
		if (!Pattern.matches("^(STD)[0-9]{3,}$", name))
			throw new CustomException("Invalid Student ID");
		return true;
	}

	public static boolean isValidProgramId(String name) throws CustomException {
		if (!Pattern.matches("^(PRG)[0-9]{3,}$", name))
			throw new CustomException("Invalid Trainer ID");
		return true;
	}

	public static boolean isValidCourseId(String name) throws CustomException {
		if (!Pattern.matches("^(CRS)[0-9]{3,}$", name))
			throw new CustomException("Invalid Trainer ID");
		return true;
	}

	public static boolean isValidPassword(String pass) throws CustomException {
		if (!Pattern.matches("^([A-Za-z0-9$#@]){6,20}$", pass))
			throw new CustomException("Invalid Password");
		return true;
	}

	public static boolean isValidBatch(String batch) throws CustomException {
		if (!Pattern.matches("^[A-Z]$", batch))
			throw new CustomException("Invalid Batch");
		return true;
	}

	public static boolean isValidId(int id) throws CustomException {
		if (id > 9999 || id < 1000)
			throw new CustomException("Invalid ID");
		return true;
	}

	public static boolean isValidQuantity(int quantity) throws CustomException {
		if (quantity <= 0)
			throw new CustomException("Invalid Quantity");
		return true;
	}

	public static boolean isValidName(String name) throws CustomException {
		if (!Pattern.matches("^([A-Z]{1}[a-z]{1,}[\\s]?)+$", name))
			throw new CustomException("Invalid Name");
		return true;
	}

	public static boolean isValidEmail(String email) throws CustomException {
		if (!Pattern.matches("^[A-Za-z0-9\\.]+(@)[A-Za-z0-9\\.]+\\.[A-Za-z]{2,}$", email))
			throw new CustomException("Invalid Address");
		return true;
	}
}
