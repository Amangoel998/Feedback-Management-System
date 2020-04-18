package com.cg.feedback.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class AdminDTO {
	
	@Id
	@Column(name="id", updatable=false)
	private String adminId;
	
	@Column(name="pass")
	private String adminPass;
	
	public String getAdminId() {
		return adminId;
	}

	public AdminDTO() {
		super();
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPass() {
		return adminPass;
	}
	
	public void setAdminPass(String adminPass) {
		this.adminPass=adminPass;
	}

}
