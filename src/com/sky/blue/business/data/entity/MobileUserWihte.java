package com.sky.blue.business.data.entity;

import com.sky.blue.business.beans.BaseEntity;

public class MobileUserWihte extends BaseEntity{
	/**
	* id
	*/
	private Integer id;
	/*
	 * 手机号
	 */
	private String mobile;
	/*
	 * 手机的imsi
	 */
	private String imsi;
	
	
	
	
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
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	
	
}
