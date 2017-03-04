package com.sky.blue.business.stat.entity;

import com.sky.blue.business.beans.BaseEntity;

public class Incomededail extends BaseEntity {
	private String dater;
	private Integer com_id;
	private String company;
	private Integer feecode_id;
	private String feecode_name;
	private Integer succ_calls;
	private Integer succ_users;
	private Integer feecode_fee;
	private Integer income_calls;
	private Double infee;
	private Double shares;
	private Integer fee;
	public String getDater() {
		return dater;
	}
	public void setDater(String dater) {
		this.dater = dater;
	}
	public Integer getCom_id() {
		return com_id;
	}
	public void setCom_id(Integer com_id) {
		this.com_id = com_id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Integer getFeecode_id() {
		return feecode_id;
	}
	public void setFeecode_id(Integer feecode_id) {
		this.feecode_id = feecode_id;
	}
	public String getFeecode_name() {
		return feecode_name;
	}
	public void setFeecode_name(String feecode_name) {
		this.feecode_name = feecode_name;
	}
	public Integer getSucc_calls() {
		return succ_calls;
	}
	public void setSucc_calls(Integer succ_calls) {
		this.succ_calls = succ_calls;
	}
	public Integer getSucc_users() {
		return succ_users;
	}
	public void setSucc_users(Integer succ_users) {
		this.succ_users = succ_users;
	}
	public Integer getFeecode_fee() {
		return feecode_fee;
	}
	public void setFeecode_fee(Integer feecode_fee) {
		this.feecode_fee = feecode_fee;
	}
	public Integer getIncome_calls() {
		return income_calls;
	}
	public void setIncome_calls(Integer income_calls) {
		this.income_calls = income_calls;
	}
	public Double getInfee() {
		return infee;
	}
	public void setInfee(Double infee) {
		this.infee = infee;
	}
	public Double getShares() {
		return shares;
	}
	public void setShares(Double shares) {
		this.shares = shares;
	}
	public Integer getFee() {
		return fee;
	}
	public void setFee(Integer fee) {
		this.fee = fee;
	}
	
}
