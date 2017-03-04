package com.sky.blue.business.cpmanager.entity;

import com.sky.blue.business.beans.BaseEntity;

public class Channel extends BaseEntity {
	private Integer ch_id;
	private String ch_name;
	private String ch_address;
	private String ch_ip;
	private String mo_url;
	private String mr_url;
	
	private String public_key;
	private String private_key;
	private String ch_account;
	private String ch_passwd;
	private String ch_pay_account;
	private Integer ch_cut;
	
	private Integer m_id;
	private String m_name;
	private Integer show_type;
	
	private Integer tag;
	private String create_name;
	
	
	public Integer getTag() {
		return tag;
	}
	public void setTag(Integer tag) {
		this.tag = tag;
	}
	public Integer getM_id() {
		return m_id;
	}
	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public Integer getShow_type() {
		return show_type;
	}
	public void setShow_type(Integer show_type) {
		this.show_type = show_type;
	}
	public Integer getCh_id() {
		return ch_id;
	}
	public void setCh_id(Integer ch_id) {
		this.ch_id = ch_id;
	}
	public String getCh_name() {
		return ch_name;
	}
	public void setCh_name(String ch_name) {
		this.ch_name = ch_name;
	}
	public String getCh_address() {
		return ch_address;
	}
	public void setCh_address(String ch_address) {
		this.ch_address = ch_address;
	}
	public String getCh_ip() {
		return ch_ip;
	}
	public void setCh_ip(String ch_ip) {
		this.ch_ip = ch_ip;
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
	public String getCh_account() {
		return ch_account;
	}
	public void setCh_account(String ch_account) {
		this.ch_account = ch_account;
	}
	public String getCh_passwd() {
		return ch_passwd;
	}
	public void setCh_passwd(String ch_passwd) {
		this.ch_passwd = ch_passwd;
	}
	public String getCh_pay_account() {
		return ch_pay_account;
	}
	public void setCh_pay_account(String ch_pay_account) {
		this.ch_pay_account = ch_pay_account;
	}
	public Integer getCh_cut() {
		return ch_cut;
	}
	public void setCh_cut(Integer ch_cut) {
		this.ch_cut = ch_cut;
	}
	
	public String getCreate_name() {
		return create_name;
	}
	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}
	@Override
	public String toString() {
		return "Channel [ch_id=" + ch_id + ", ch_name=" + ch_name
				+ ", ch_address=" + ch_address + ", ch_ip=" + ch_ip
				+ ", mo_url=" + mo_url + ", mr_url=" + mr_url + ", public_key="
				+ public_key + ", private_key=" + private_key + ", ch_account="
				+ ch_account + ", ch_passwd=" + ch_passwd + ", ch_pay_account="
				+ ch_pay_account + ", ch_cut=" + ch_cut + ", getArrayIds()="
				+ getArrayIds() + ", getRemarks()=" + getRemarks()
				+ ", getCreate_time()=" + getCreate_time()
				+ ", getUpdate_time()=" + getUpdate_time()
				+ ", getCreate_name()=" + getCreate_name()
				+ ", getUpdate_name()=" + getUpdate_name() + "]";
	}
	
	
}
