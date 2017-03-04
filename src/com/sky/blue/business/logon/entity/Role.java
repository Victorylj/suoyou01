package com.sky.blue.business.logon.entity;

import com.sky.blue.business.beans.BaseEntity;

public class Role extends BaseEntity {
	private Integer role_id;
	private String role_name;
	
	private Module[] moduleList;
	private String modules[];
	private String ref_modules;
	
	public String[] getModules() {
		return modules;
	}
	public void setModules(String[] modules) {
		this.modules = modules;
	}
	public String getRef_modules() {
		return ref_modules;
	}
	public void setRef_modules(String ref_modules) {
		this.ref_modules = ref_modules;
	}
	public Module[] getModuleList() {
		return moduleList;
	}
	public void setModuleList(Module[] moduleList) {
		this.moduleList = moduleList;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
}
