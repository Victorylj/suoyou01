package com.sky.blue.business.stat.entity;

import com.sky.blue.business.beans.BaseEntity;

public class FeecodeStat extends BaseEntity {
	private String dater;
	private String op;
	private String feecode_id;
	private String feecode_number;
	private String feecode_name;

	private String command;
	private Integer succ_calls;
	private Integer succ_users;
	private String province_id;
	private String province_name;
	private String sp_id;
	private String sp_name;
	private Integer feecode_fee;
	
	private Integer command_status;
	private Integer mo_num;
	private Integer mr_num;
	private Integer rate;
	
	public String getSp_id() {
		return sp_id;
	}
	public void setSp_id(String sp_id) {
		this.sp_id = sp_id;
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
	public Integer getMo_num() {
		return mo_num;
	}
	public void setMo_num(Integer mo_num) {
		this.mo_num = mo_num;
	}
	public Integer getMr_num() {
		return mr_num;
	}
	public void setMr_num(Integer mr_num) {
		this.mr_num = mr_num;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	public Integer getCommand_status() {
		return command_status;
	}
	public void setCommand_status(Integer command_status) {
		this.command_status = command_status;
	}

}
