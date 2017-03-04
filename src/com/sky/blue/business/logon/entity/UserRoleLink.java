package com.sky.blue.business.logon.entity;

import com.sky.blue.business.beans.BaseEntity;

public class UserRoleLink extends BaseEntity {
	private Integer user_id;
	private Integer role_id;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
}
