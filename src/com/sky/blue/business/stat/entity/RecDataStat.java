package com.sky.blue.business.stat.entity;

import com.sky.blue.business.beans.BaseEntity;

public class RecDataStat extends BaseEntity {
	private String dater;
	private String op;
	private String sp_id;
	private String dtype;
	private String feecode_id;
	private String feecode_number;
	private String feecode_name;
	private String spnumber;
	private String command;
	private Integer succ_calls;
	private Integer succ_users;
	private String province_id;
	private String province_name;
	private String sp_name;
	private Integer income_calls;
	private Integer income_user;

	private Integer feecode_fee;
	private String cp_id;
	private String cp_name;
	private String appfee_id;
	private Integer fee;
	
	private String is_province;
	private String is_detail;
	private String is_ch;
	private String rate;
	
	private Float share;
	
	private String incomeb;
	private String rateb;
	
	private Integer sp_gsstatus;
	
	private int delaymiute;

	public int getDelaymiute() {
		return delaymiute;
	}
	public void setDelaymiute(int delaymiute) {
		this.delaymiute = delaymiute;
	}
	public Integer getSp_gsstatus() {
		return sp_gsstatus;
	}
	public void setSp_gsstatus(Integer sp_gsstatus) {
		this.sp_gsstatus = sp_gsstatus;
	}
	public String getIncomeb() {
		return incomeb;
	}
	public void setIncomeb(String incomeb) {
		this.incomeb = incomeb;
	}
	public String getRateb() {
		return rateb;
	}
	public void setRateb(String rateb) {
		this.rateb = rateb;
	}
	public String getDtype() {
		return dtype;
	}
	public void setDtype(String dtype) {
		this.dtype = dtype;
	}
	public String getIs_ch() {
		return is_ch;
	}
	public void setIs_ch(String is_ch) {
		this.is_ch = is_ch;
	}
	public Integer getIncome_calls() {
		return income_calls;
	}
	public void setIncome_calls(Integer income_calls) {
		this.income_calls = income_calls;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getIs_province() {
		return is_province;
	}
	public void setIs_province(String is_province) {
		this.is_province = is_province;
	}
	public String getIs_detail() {
		return is_detail;
	}
	public void setIs_detail(String is_detail) {
		this.is_detail = is_detail;
	}
	public String getSp_id() {
		return sp_id;
	}
	public void setSp_id(String sp_id) {
		this.sp_id = sp_id;
	}
	public Integer getIncome_user() {
		return income_user;
	}
	public void setIncome_user(Integer income_user) {
		this.income_user = income_user;
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
	public String getSpnumber() {
		return spnumber;
	}
	public void setSpnumber(String spnumber) {
		this.spnumber = spnumber;
	}
	public Integer getFee() {
		return fee;
	}
	public void setFee(Integer fee) {
		this.fee = fee;
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
	public Float getShare() {
		return share;
	}
	public void setShare(Float share) {
		this.share = share;
	}

}
