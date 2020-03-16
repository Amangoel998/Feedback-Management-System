package com.cg.feedback.dto;

public class SkillDTO {
	private String skillId;
	private String skillName;
	
	//Constructor
	public SkillDTO(String skillId, String skillName) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
	}
	
	
	//Getters and Setters
	public String getSkillId() {
		return skillId;
	}
	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}	
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
	@Override
	public boolean equals(Object obj) {
		SkillDTO temp=(SkillDTO)obj;
		if(this.skillName.equals(temp.getSkillName()))
			return true;
		return false;
	}


	@Override
	public String toString() {
		return "SkillDTO [skillId=" + skillId + ", skillName=" + skillName + "]";
	}
	

}
