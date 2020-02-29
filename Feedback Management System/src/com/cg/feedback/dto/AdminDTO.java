package com.cg.feedback.dto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AdminDTO {
	private static String adminId;
	private static String adminPass;
	
	public AdminDTO(){
		Properties credentials = new Properties();
		try {
			credentials.load(new FileInputStream("resources/admin_credentials.properties"));
			adminId = credentials.getProperty("adminId");
			adminPass = credentials.getProperty("adminPass");
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
	}
	public static String getAdminPass() {
		return adminPass;
	}
	public static void setAdminPass(String adminPass) {
		AdminDTO.adminPass = adminPass;
	}
	
	public String getAdminId() {
		return adminId;
	}
	

}
