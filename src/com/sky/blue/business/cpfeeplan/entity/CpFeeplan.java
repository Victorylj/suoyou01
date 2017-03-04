package com.sky.blue.business.cpfeeplan.entity;

import com.sky.blue.business.beans.BaseEntity;

public class CpFeeplan extends BaseEntity {
	private Integer feeplan_id;
	private String feeplan_code;
	private String feeplan_name;
	private Integer net_type;
	private Integer feeplan_fee;
	private String create_name;
	@Override
	public String toString() {
		return "CpFeeplan [feeplan_id=" + feeplan_id + ", feeplan_code="
				+ feeplan_code + ", feeplan_name=" + feeplan_name
				+ ", net_type=" + net_type + ", feeplan_fee=" + feeplan_fee
				+ ", getArrayIds()=" + getArrayIds() + ", getRemarks()="
				+ getRemarks() + ", getCreate_time()=" + getCreate_time()
				+ ", getUpdate_time()=" + getUpdate_time()
				+ ", getCreate_name()=" + getCreate_name()
				+ ", getUpdate_name()=" + getUpdate_name() + "]";
	}
	public Integer getFeeplan_id() {
		return feeplan_id;
	}
	public void setFeeplan_id(Integer feeplan_id) {
		this.feeplan_id = feeplan_id;
	}
	public String getFeeplan_code() {
		return feeplan_code;
	}
	public void setFeeplan_code(String feeplan_code) {
		this.feeplan_code = feeplan_code;
	}
	public String getFeeplan_name() {
		return feeplan_name;
	}
	public void setFeeplan_name(String feeplan_name) {
		this.feeplan_name = feeplan_name;
	}
	public Integer getNet_type() {
		return net_type;
	}
	public void setNet_type(Integer net_type) {
		this.net_type = net_type;
	}
	public Integer getFeeplan_fee() {
		return feeplan_fee;
	}
	public void setFeeplan_fee(Integer feeplan_fee) {
		this.feeplan_fee = feeplan_fee;
	}
	public String getCreate_name() {
		return create_name;
	}
	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}
	
}
