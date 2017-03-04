package com.sky.blue.business.spmanager.entity;

import com.sky.blue.business.beans.BaseEntity;

public class SpChannel extends BaseEntity {
	private Integer sp_channel_id;
	private String sp_name;
	private Integer sp_id;
	private String sp_channel_ip;
	private String sp_channel_name;
	private String sp_channel_mo_url;
	private String sp_channel_mr_url;
	private String sp_channel_status;
	private String create_name;
	public Integer getSp_channel_id() {
		return sp_channel_id;
	}
	public void setSp_channel_id(Integer sp_channel_id) {
		this.sp_channel_id = sp_channel_id;
	}
	public Integer getSp_id() {
		return sp_id;
	}
	public void setSp_id(Integer sp_id) {
		this.sp_id = sp_id;
	}
	public String getSp_channel_ip() {
		return sp_channel_ip;
	}
	public void setSp_channel_ip(String sp_channel_ip) {
		this.sp_channel_ip = sp_channel_ip;
	}
	public String getSp_channel_mo_url() {
		return sp_channel_mo_url;
	}
	public void setSp_channel_mo_url(String sp_channel_mo_url) {
		this.sp_channel_mo_url = sp_channel_mo_url;
	}
	public String getSp_channel_mr_url() {
		return sp_channel_mr_url;
	}
	public void setSp_channel_mr_url(String sp_channel_mr_url) {
		this.sp_channel_mr_url = sp_channel_mr_url;
	}
	public String getSp_channel_status() {
		return sp_channel_status;
	}
	public void setSp_channel_status(String sp_channel_status) {
		this.sp_channel_status = sp_channel_status;
	}
	@Override
	public String toString() {
		return "SpChannel [sp_channel_id=" + sp_channel_id + ", sp_id=" + sp_id
				+ ", sp_channel_ip=" + sp_channel_ip + ", sp_channel_mo_url="
				+ sp_channel_mo_url + ", sp_channel_mr_url="
				+ sp_channel_mr_url + ", sp_channel_status="
				+ sp_channel_status + ", getArrayIds()=" + getArrayIds()
				+ ", getRemarks()=" + getRemarks() + ", getCreate_time()="
				+ getCreate_time() + ", getUpdate_time()=" + getUpdate_time()
				+ ", getCreate_name()=" + getCreate_name()
				+ ", getUpdate_name()=" + getUpdate_name() + "]";
	}
	public String getSp_name() {
		return sp_name;
	}
	public void setSp_name(String sp_name) {
		this.sp_name = sp_name;
	}
	public String getSp_channel_name() {
		return sp_channel_name;
	}
	public void setSp_channel_name(String sp_channel_name) {
		this.sp_channel_name = sp_channel_name;
	}
	public String getCreate_name() {
		return create_name;
	}
	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}
	
	
}
