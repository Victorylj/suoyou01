package com.sky.blue.business.spmanager.entity;

import com.sky.blue.business.beans.BaseEntity;

public class SpFeecodeGroup extends BaseEntity {
	private Integer g_id;
	private String g_name;
	private Integer g_op;
	private Integer g_interval;
	private String remarks;
	public Integer getG_id() {
		return g_id;
	}
	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public Integer getG_op() {
		return g_op;
	}
	public void setG_op(Integer g_op) {
		this.g_op = g_op;
	}
	public Integer getG_interval() {
		return g_interval;
	}
	public void setG_interval(Integer g_interval) {
		this.g_interval = g_interval;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
