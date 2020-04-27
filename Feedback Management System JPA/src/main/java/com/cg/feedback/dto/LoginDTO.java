package com.cg.feedback.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class LoginDTO {
	
	@Id
	@Column(name="userid", updatable=false, nullable=false)
	private String userId;
	
	@Column(name="userpass", nullable=false)
	private String userPass;
	
	@Column(name="role", updatable=false, nullable=false)
	private String role;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LoginDTO(String userId, String userPass, String role) {
		super();
		this.userId = userId;
		this.userPass = userPass;
		this.role = role;
	}

	public LoginDTO() {
		super();
	}

	@Override
	public String toString() {
		return "LoginDTO [userId=" + userId + ", userPass=" + userPass + ", role=" + role + "]";
	}
	
	
}
