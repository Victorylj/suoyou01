package com.sky.blue.business.spmanager.entity;

import com.sky.blue.business.beans.BaseEntity;

public class FilterSpCom extends BaseEntity {
	private int id;
	private String cpid;  //产品
	private int commandid; //指令id
	private int status; //是否过滤状态
	private int onoff;  //是指定选项还是过滤选项开关
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpid() {
		return cpid;
	}
	public void setCpid(String cpid) {
		this.cpid = cpid;
	}
	public int getCommandid() {
		return commandid;
	}
	public void setCommandid(int commandid) {
		this.commandid = commandid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getOnoff() {
		return onoff;
	}
	public void setOnoff(int onoff) {
		this.onoff = onoff;
	}
	
}
