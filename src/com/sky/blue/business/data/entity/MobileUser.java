package com.sky.blue.business.data.entity;

import com.sky.blue.business.beans.BaseEntity;

public class MobileUser extends BaseEntity{
	private Integer id;
	private String dater;
	
	public String getDater() {
		return dater;
	}
	public void setDater(String dater) {
		this.dater = dater;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	private String mobile;
}
