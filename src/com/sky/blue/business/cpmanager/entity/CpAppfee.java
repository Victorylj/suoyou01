package com.sky.blue.business.cpmanager.entity;

import com.sky.blue.business.beans.BaseEntity;

public class CpAppfee extends BaseEntity {
	private Integer appfee_id;
	private String product_name;
	private Integer product_id;
	private String appfee_name;
	private Integer appfee_fee;
	private Integer appfee_isoverfee;
	private Integer appfee_status;
	
	private Integer feeplan_id;
	private String feeplan_name;
	private Integer net_type;
	private Integer feeplan_fee;
	private Integer feeplan_status;
	
	private String create_name;
	
	@Override
	public String toString() {
		return "CpAppfee [appfee_id=" + appfee_id + ", product_name="
				+ product_name + ", product_id=" + product_id
				+ ", appfee_name=" + appfee_name + ", appfee_fee=" + appfee_fee
				+ ", appfee_isoverfee=" + appfee_isoverfee + ", appfee_status="
				+ appfee_status + ", getArrayIds()=" + getArrayIds()
				+ ", getRemarks()=" + getRemarks() + ", getCreate_time()="
				+ getCreate_time() + ", getUpdate_time()=" + getUpdate_time()
				+ ", getCreate_name()=" + getCreate_name()
				+ ", getUpdate_name()=" + getUpdate_name() + "]";
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


	public Integer getFeeplan_status() {
		return feeplan_status;
	}


	public void setFeeplan_status(Integer feeplan_status) {
		this.feeplan_status = feeplan_status;
	}


	public Integer getFeeplan_id() {
		return feeplan_id;
	}


	public void setFeeplan_id(Integer feeplan_id) {
		this.feeplan_id = feeplan_id;
	}


	public String getFeeplan_name() {
		return feeplan_name;
	}


	public void setFeeplan_name(String feeplan_name) {
		this.feeplan_name = feeplan_name;
	}


	public Integer getAppfee_id() {
		return appfee_id;
	}
	public void setAppfee_id(Integer appfee_id) {
		this.appfee_id = appfee_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getAppfee_name() {
		return appfee_name;
	}
	public void setAppfee_name(String appfee_name) {
		this.appfee_name = appfee_name;
	}
	public Integer getAppfee_fee() {
		return appfee_fee;
	}
	public void setAppfee_fee(Integer appfee_fee) {
		this.appfee_fee = appfee_fee;
	}
	public Integer getAppfee_isoverfee() {
		return appfee_isoverfee;
	}
	public void setAppfee_isoverfee(Integer appfee_isoverfee) {
		this.appfee_isoverfee = appfee_isoverfee;
	}
	public Integer getAppfee_status() {
		return appfee_status;
	}
	public void setAppfee_status(Integer appfee_status) {
		this.appfee_status = appfee_status;
	}


	public String getCreate_name() {
		return create_name;
	}


	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}
	
	
}
