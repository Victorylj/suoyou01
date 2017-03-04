package com.sky.blue.business.stat.entity;

import com.sky.blue.business.beans.BaseEntity;

public class Calldetail extends BaseEntity {
	private String dater;
	private Integer cpid;
	private String cpname;
	private Integer proid;
	private String proname;
	private Integer initnum;
	private Integer succ_users;
	private Double fee;
	private Double ofee;
	private String uname;
	public String getDater() {
		return dater;
	}
	public void setDater(String dater) {
		this.dater = dater;
	}
	public Integer getCpid() {
		return cpid;
	}
	public void setCpid(Integer cpid) {
		this.cpid = cpid;
	}
	public String getCpname() {
		return cpname;
	}
	public void setCpname(String cpname) {
		this.cpname = cpname;
	}
	public Integer getProid() {
		return proid;
	}
	public void setProid(Integer proid) {
		this.proid = proid;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public Integer getInitnum() {
		return initnum;
	}
	public void setInitnum(Integer initnum) {
		this.initnum = initnum;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	public Integer getSucc_users() {
		return succ_users;
	}
	public void setSucc_users(Integer succ_users) {
		this.succ_users = succ_users;
	}
	public Double getOfee() {
		return ofee;
	}
	public void setOfee(Double ofee) {
		this.ofee = ofee;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	
}
