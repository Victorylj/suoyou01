package com.sky.blue.business.stat.entity;

import com.sky.blue.business.beans.BaseEntity;

public class RecData extends BaseEntity {
	private String dater;
	private Integer sp_id;
	private String sp_name;
	private String op;
	private String feecode_id;
	private String feecode_number;
	private String spnumber;
	private String feecode_name;
	private String msg;
	private	String mobile;
	private String linkid;
	private String status_code;
	private String cp_id;
	private String cp_name;
	private String appfee_id;
	
	private String command;
	private Integer succ_calls;
	private Integer succ_users;
	private String province_id;
	private String province_name;

	private Integer feecode_fee;
	
	
	public String getSpnumber() {
		return spnumber;
	}
	public void setSpnumber(String spnumber) {
		this.spnumber = spnumber;
	}
	private String savetime;
	
	public String getSavetime() {
		return savetime;
	}
	public void setSavetime(String savetime) {
		this.savetime = savetime;
	}
	public String getSp_name() {
		return sp_name;
	}
	public void setSp_name(String sp_name) {
		this.sp_name = sp_name;
	}
	public Integer getFeecode_fee() {
		return feecode_fee;
	}
	public void setFeecode_fee(Integer feecode_fee) {
		this.feecode_fee = feecode_fee;
	}
	public String getDater() {
		return dater;
	}
	public void setDater(String dater) {
		this.dater = dater;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getFeecode_id() {
		return feecode_id;
	}
	public void setFeecode_id(String feecode_id) {
		this.feecode_id = feecode_id;
	}
	public String getFeecode_number() {
		return feecode_number;
	}
	public void setFeecode_number(String feecode_number) {
		this.feecode_number = feecode_number;
	}
	public String getFeecode_name() {
		return feecode_name;
	}
	public void setFeecode_name(String feecode_name) {
		this.feecode_name = feecode_name;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
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
	
	public String getProvince_id() {
		return province_id;
	}
	public void setProvince_id(String province_id) {
		this.province_id = province_id;
	}
	public String getProvince_name() {
		return province_name;
	}
	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}
	public Integer getSp_id() {
		return sp_id;
	}
	public void setSp_id(Integer sp_id) {
		this.sp_id = sp_id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLinkid() {
		return linkid;
	}
	public void setLinkid(String linkid) {
		this.linkid = linkid;
	}
	public String getStatus_code() {
		return status_code;
	}
	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}
	public String getCp_id() {
		return cp_id;
	}
	public void setCp_id(String cp_id) {
		this.cp_id = cp_id;
	}
	public String getCp_name() {
		return cp_name;
	}
	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}
	public String getAppfee_id() {
		return appfee_id;
	}
	public void setAppfee_id(String appfee_id) {
		this.appfee_id = appfee_id;
	}

	
}
