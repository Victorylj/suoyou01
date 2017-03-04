package com.sky.blue.business.stat.entity;

import com.sky.blue.business.beans.BaseEntity;

public class SmsFilterStat extends BaseEntity {
	private String cp_id;
	private	String appfee_id;
	private String filter_port;
	private String filter_content;
	private Integer filterUsers;
	private Integer filterNum;
	private String dater;
	public String getCp_id() {
		return cp_id;
	}
	public void setCp_id(String cp_id) {
		this.cp_id = cp_id;
	}
	public String getAppfee_id() {
		return appfee_id;
	}
	public void setAppfee_id(String appfee_id) {
		this.appfee_id = appfee_id;
	}
	public String getFilter_port() {
		return filter_port;
	}
	public void setFilter_port(String filter_port) {
		this.filter_port = filter_port;
	}
	public String getFilter_content() {
		return filter_content;
	}
	public void setFilter_content(String filter_content) {
		this.filter_content = filter_content;
	}

	public Integer getFilterUsers() {
		return filterUsers;
	}
	public void setFilterUsers(Integer filterUsers) {
		this.filterUsers = filterUsers;
	}
	public Integer getFilterNum() {
		return filterNum;
	}
	public void setFilterNum(Integer filterNum) {
		this.filterNum = filterNum;
	}
	public String getDater() {
		return dater;
	}
	public void setDater(String dater) {
		this.dater = dater;
	}

	
	
	
}
