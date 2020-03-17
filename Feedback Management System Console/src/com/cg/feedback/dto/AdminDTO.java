package com.cg.feedback.dto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.cg.feedback.exceptions.CustomException;

public class AdminDTO {
	private static String adminId;
	private static String adminPass;
	private static AdminDTO admin;
	private AdminDTO() {
		Properties credentials = new Properties();
		try {
			credentials.load(new FileInputStream("resources/admin_credentials.properties"));
			adminId = credentials.getProperty("admin.Id");
			adminPass = credentials.getProperty("admin.Pass");
		} catch (FileNotFoundException e) {
			throw new CustomException("Couldn't Load Admin Credenetials");
		} catch (IOException e) {
			throw new CustomException("Couldn't have Admin Credenetials");
		}
	}
	
	public static AdminDTO validateAdmin(String user, String pass) {
		if( adminId.equals(user) && adminPass.equals(pass)){
			if(admin==null)
				admin = new AdminDTO();
		}
		return admin;
	}

	public static void setAdminPass(String newPass) {
		Properties credentials = new Properties();
		try {
			credentials.put("admin.Id", adminId);
			credentials.put("admin.Pass", newPass);
			credentials.store(new FileOutputStream("resources/admin_credentials.properties"), "");
			adminPass = newPass;
		} catch (FileNotFoundException e) {
			throw new CustomException("Couldn't Store Admin Credenetials");

		} catch (IOException e) {
			throw new CustomException("Couldn't have Admin Credenetials");
		}
	}

}
