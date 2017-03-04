package com.sky.blue.business.logon.entity;

import com.sky.blue.business.beans.BaseEntity;

public class ModuleRoleLink extends BaseEntity {
	private Integer module_id;
	private Integer role_id;
	public Integer getModule_id() {
		return module_id;
	}
	public void setModule_id(Integer module_id) {
		this.module_id = module_id;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	
}
