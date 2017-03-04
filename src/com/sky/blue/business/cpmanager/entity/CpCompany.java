package com.sky.blue.business.cpmanager.entity;

import com.sky.blue.business.beans.BaseEntity;

public class CpCompany extends BaseEntity {
	private Integer cp_id;
	private String cp_name;
	private String cp_address;
	private String cp_ip;
	private String mo_url;
	private String mr_url;
	
	private String public_key;
	private String private_key;
	private String cp_account;
	private String cp_passwd;
	private String cp_pay_account;
	private Integer cp_cut;
	private String create_name;
	
	public Integer getCp_id() {
		return cp_id;
	}
	public void setCp_id(Integer cp_id) {
		this.cp_id = cp_id;
	}
	public String getCp_name() {
		return cp_name;
	}
	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}
	public String getCp_address() {
		return cp_address;
	}
	public void setCp_address(String cp_address) {
		this.cp_address = cp_address;
	}
	public String getCp_ip() {
		return cp_ip;
	}
	public void setCp_ip(String cp_ip) {
		this.cp_ip = cp_ip;
	}
	public String getMo_url() {
		return mo_url;
	}
	public void setMo_url(String mo_url) {
		this.mo_url = mo_url;
	}
	public String getMr_url() {
		return mr_url;
	}
	public void setMr_url(String mr_url) {
		this.mr_url = mr_url;
	}
	public String getPublic_key() {
		return public_key;
	}
	public void setPublic_key(String public_key) {
		this.public_key = public_key;
	}
	public String getPrivate_key() {
		return private_key;
	}
	public void setPrivate_key(String private_key) {
		this.private_key = private_key;
	}
	public String getCp_account() {
		return cp_account;
	}
	public void setCp_account(String cp_account) {
		this.cp_account = cp_account;
	}
	public String getCp_passwd() {
		return cp_passwd;
	}
	public void setCp_passwd(String cp_passwd) {
		this.cp_passwd = cp_passwd;
	}
	public String getCp_pay_account() {
		return cp_pay_account;
	}
	public void setCp_pay_account(String cp_pay_account) {
		this.cp_pay_account = cp_pay_account;
	}
	public Integer getCp_cut() {
		return cp_cut;
	}
	public void setCp_cut(Integer cp_cut) {
		this.cp_cut = cp_cut;
	}
	
	
	
	public String getCreate_name() {
		return create_name;
	}
	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}
	@Override
	public String toString() {
		return "CpCompany [cp_id=" + cp_id + ", cp_name=" + cp_name
				+ ", cp_address=" + cp_address + ", cp_ip=" + cp_ip
				+ ", mo_url=" + mo_url + ", mr_url=" + mr_url + ", public_key="
				+ public_key + ", private_key=" + private_key + ", cp_account="
				+ cp_account + ", cp_passwd=" + cp_passwd + ", cp_pay_account="
				+ cp_pay_account + ", cp_cut=" + cp_cut + ", getArrayIds()="
				+ getArrayIds() + ", getRemarks()=" + getRemarks()
				+ ", getCreate_time()=" + getCreate_time()
				+ ", getUpdate_time()=" + getUpdate_time()
				+ ", getCreate_name()=" + getCreate_name()
				+ ", getUpdate_name()=" + getUpdate_name() + "]";
	}
	
	
}
