package com.cg.feedback.dto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.cg.feedback.exceptions.CustomException;

//admin_credentials.properties not present!
public class AdminDTO {
	private static String adminId = "ADM101";
	private static String adminPass = "admin101";
	private static AdminDTO admin = null;
	private final static Properties credentials = new Properties();

	private AdminDTO() {
		try {
			credentials.load(getClass().getResourceAsStream("admin_credentials.properties"));
			adminId = credentials.getProperty("admin.Id");
			adminPass = credentials.getProperty("admin.Pass");
		} catch (FileNotFoundException e) {
			throw new CustomException("Couldn't Load Admin Credentials");
		} catch (IOException e) {
			throw new CustomException("Couldn't get Admin Credentials");
		}
	}

	public static AdminDTO validateAdmin(String user, String pass) {
		if (admin == null) {
			admin = new AdminDTO();
		}
		if (adminId.equals(user) && adminPass.equals(pass)) {
			return admin;
		} else
			return null;
	}

	public static void setAdminPass(String newPass) {
		Properties credentials = new Properties();
		try {
			if (credentials.setProperty("admin.Pass", newPass) == null)
				throw new CustomException("Couldn't have Admin Credenetials");
			adminPass = newPass;
		} catch (CustomException e) {
			throw new CustomException(e.getMessage());
		}
	}

}
