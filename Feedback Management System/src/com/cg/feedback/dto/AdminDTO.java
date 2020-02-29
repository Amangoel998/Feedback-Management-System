package com.cg.feedback.dto;

public class AdminDTO {
	private final String adminId="Admin123";
	private static String adminPass="Admin123";
	
	
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
