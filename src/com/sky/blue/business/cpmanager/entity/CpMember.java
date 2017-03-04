package com.sky.blue.business.cpmanager.entity;

import com.sky.blue.business.beans.BaseEntity;

public class CpMember extends BaseEntity {
 
	private Integer cpm_id;
	private String cpm_name;
	public Integer getCpm_id() {
		return cpm_id;
	}
	public void setCpm_id(Integer cpm_id) {
		this.cpm_id = cpm_id;
	}
	public String getCpm_name() {
		return cpm_name;
	}
	public void setCpm_name(String cpm_name) {
		this.cpm_name = cpm_name;
	}
	
	

}
