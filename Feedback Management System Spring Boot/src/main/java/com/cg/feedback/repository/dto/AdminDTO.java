package com.cg.feedback.repository.dto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cg.feedback.repository.exceptions.CustomException;

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
