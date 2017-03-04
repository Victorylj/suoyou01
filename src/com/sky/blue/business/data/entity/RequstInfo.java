package com.sky.blue.business.data.entity;

import com.sky.blue.business.beans.BaseEntity;

public class RequstInfo extends BaseEntity{
	private String mobile_imsi;
	private String imsi;
	private String mobile;
	private String appfee_id;
	private String cpinfo_id;;
	private String ccp_id;
	private String province_name;
	private String feecode_number;
	private String command;
	private String feecodes;
	private String feecode_id;
	private String sp_id;
	private String sp_name;
	private String feecode_name;
	private String savetime;
	private String packagestr;
	private String error_name;
	private String error_info;
	private int setCount = 20;
	
	
	public String getFeecode_name() {
		return feecode_name;
	}
	public void setFeecode_name(String feecode_name) {
		this.feecode_name = feecode_name;
	}
	public int getSetCount() {
		return setCount;
	}
	public void setSetCount(int setCount) {
		this.setCount = setCount;
	}
	public String getFeecode_id() {
		return feecode_id;
	}
	public void setFeecode_id(String feecode_id) {
		this.feecode_id = feecode_id;
	}
	public String getFeecodes() {
		return feecodes;
	}
	public void setFeecodes(String feecodes) {
		this.feecodes = feecodes;
	}
	public String getSp_name() {
		return sp_name;
	}
	public void setSp_name(String sp_name) {
		this.sp_name = sp_name;
	}
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	public String getFeecode_number() {
		return feecode_number;
	}
	public void setFeecode_number(String feecode_number) {
		this.feecode_number = feecode_number;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getSp_id() {
		return sp_id;
	}
	public void setSp_id(String sp_id) {
		this.sp_id = sp_id;
	}
	public String getSavetime() {
		return savetime;
	}
	public void setSavetime(String savetime) {
		this.savetime = savetime;
	}
	public String getAppfee_id() {
		return appfee_id;
	}
	public void setAppfee_id(String appfee_id) {
		this.appfee_id = appfee_id;
	}
	public String getMobile_imsi() {
		return mobile_imsi;
	}
	public void setMobile_imsi(String mobile_imsi) {
		this.mobile_imsi = mobile_imsi;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCpinfo_id() {
		return cpinfo_id;
	}
	public void setCpinfo_id(String cpinfo_id) {
		this.cpinfo_id = cpinfo_id;
	}
	public String getCcp_id() {
		return ccp_id;
	}
	public void setCcp_id(String ccp_id) {
		this.ccp_id = ccp_id;
	}
	public String getProvince_name() {
		return province_name;
	}
	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}
	public String getPackagestr() {
		return packagestr;
	}
	public void setPackagestr(String packagestr) {
		this.packagestr = packagestr;
	}
	public String getError_name() {
		return error_name;
	}
	public void setError_name(String error_name) {
		this.error_name = error_name;
	}
	public String getError_info() {
		return error_info;
	}
	public void setError_info(String error_info) {
		this.error_info = error_info;
	}
	
	
	
	
}
