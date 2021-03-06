package com.sky.blue.business.beans;

import java.util.Date;

import com.sky.blue.business.logon.entity.User;



public class LoginLog extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private int loginLogId;
	

	private Date loginDate;
	

    private User user;
	
	private String ip;
	
	
	public int getLoginLogId() {
		return loginLogId;
	}
	public void setLoginLogId(int loginLogId) {
		this.loginLogId = loginLogId;
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
