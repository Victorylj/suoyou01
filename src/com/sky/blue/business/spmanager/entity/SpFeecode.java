package com.sky.blue.business.spmanager.entity;

import com.sky.blue.business.beans.BaseEntity;

public class SpFeecode extends BaseEntity {
	private Integer feecode_id;
	private String feecode_code;
	private String feecode_name;
	private Integer feecode_op;
	private Integer feecode_mutex;
	public Integer getFeecode_op() {
		return feecode_op;
	}
	public void setFeecode_op(Integer feecode_op) {
		this.feecode_op = feecode_op;
	}

	private String sp_name;
	@Override
	public String toString() {
		return "SpFeecode [feecode_id=" + feecode_id + ", feecode_code="
				+ feecode_code + ", feecode_name=" + feecode_name
				+ ", sp_name=" + sp_name + ", sp_id=" + sp_id
				+ ", sp_channel_id=" + sp_channel_id + ", sp_channel_name="
				+ sp_channel_name + ", feecode_number=" + feecode_number
				+ ", feecode_fee=" + feecode_fee + ", feecode_type="
				+ feecode_type + ", getArrayIds()=" + getArrayIds()
				+ ", getRemarks()=" + getRemarks() + ", getCreate_time()="
				+ getCreate_time() + ", getUpdate_time()=" + getUpdate_time()
				+ ", getCreate_name()=" + getCreate_name()
				+ ", getUpdate_name()=" + getUpdate_name() + "]";
	}
	private Integer sp_id;
	private Integer sp_channel_id;
	private String sp_channel_name;
	private String feecode_number;
	private Integer feecode_fee;
	private Integer feecode_type;
	private Integer group_id;
	private String group_name;
	
	private Integer hz ; //上量频率
	
	
	public Integer getHz() {
		return hz;
	}
	public void setHz(Integer hz) {
		this.hz = hz;
	}
	public Integer getFeecode_id() {
		return feecode_id;
	}
	public void setFeecode_id(Integer feecode_id) {
		this.feecode_id = feecode_id;
	}
	public String getFeecode_code() {
		return feecode_code;
	}
	public void setFeecode_code(String feecode_code) {
		this.feecode_code = feecode_code;
	}
	public String getFeecode_name() {
		return feecode_name;
	}
	public void setFeecode_name(String feecode_name) {
		this.feecode_name = feecode_name;
	}
	public String getSp_name() {
		return sp_name;
	}
	public void setSp_name(String sp_name) {
		this.sp_name = sp_name;
	}
	public Integer getSp_id() {
		return sp_id;
	}
	public void setSp_id(Integer sp_id) {
		this.sp_id = sp_id;
	}
	public Integer getSp_channel_id() {
		return sp_channel_id;
	}
	public void setSp_channel_id(Integer sp_channel_id) {
		this.sp_channel_id = sp_channel_id;
	}
	public String getSp_channel_name() {
		return sp_channel_name;
	}
	public void setSp_channel_name(String sp_channel_name) {
		this.sp_channel_name = sp_channel_name;
	}
	public String getFeecode_number() {
		return feecode_number;
	}
	public void setFeecode_number(String feecode_number) {
		this.feecode_number = feecode_number;
	}
	public Integer getFeecode_fee() {
		return feecode_fee;
	}
	public void setFeecode_fee(Integer feecode_fee) {
		this.feecode_fee = feecode_fee;
	}
	public Integer getFeecode_type() {
		return feecode_type;
	}
	public void setFeecode_type(Integer feecode_type) {
		this.feecode_type = feecode_type;
	}
	public Integer getGroup_id() {
		return group_id;
	}
	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}
	public Integer getFeecode_mutex() {
		return feecode_mutex;
	}
	public void setFeecode_mutex(Integer feecode_mutex) {
		this.feecode_mutex = feecode_mutex;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	
}
