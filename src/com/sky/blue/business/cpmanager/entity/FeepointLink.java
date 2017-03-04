package com.sky.blue.business.cpmanager.entity;

import com.sky.blue.business.beans.BaseEntity;

public class FeepointLink extends BaseEntity {
	private Integer feepointplan_id;
	private Integer appfee_id;
	private String product_name;
	private String appfee_name;
	private Integer appfee_fee;
	private Integer feeplan_id;
	private String feeplan_name;
	
	private Integer feemeasure_id;
	private String feemeasure_name;
	
	public String getFeeplan_name() {
		return feeplan_name;
	}
	public void setFeeplan_name(String feeplan_name) {
		this.feeplan_name = feeplan_name;
	}
	public Integer getFeeplan_id() {
		return feeplan_id;
	}
	public void setFeeplan_id(Integer feeplan_id) {
		this.feeplan_id = feeplan_id;
	}
	public Integer getAppfee_fee() {
		return appfee_fee;
	}
	public void setAppfee_fee(Integer appfee_fee) {
		this.appfee_fee = appfee_fee;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getAppfee_name() {
		return appfee_name;
	}
	public void setAppfee_name(String appfee_name) {
		this.appfee_name = appfee_name;
	}
	public String getFeemeasure_name() {
		return feemeasure_name;
	}
	public void setFeemeasure_name(String feemeasure_name) {
		this.feemeasure_name = feemeasure_name;
	}
	public Integer getFeepointplan_id() {
		return feepointplan_id;
	}
	public void setFeepointplan_id(Integer feepointplan_id) {
		this.feepointplan_id = feepointplan_id;
	}
	public Integer getAppfee_id() {
		return appfee_id;
	}
	public void setAppfee_id(Integer appfee_id) {
		this.appfee_id = appfee_id;
	}
	public Integer getFeemeasure_id() {
		return feemeasure_id;
	}
	public void setFeemeasure_id(Integer feemeasure_id) {
		this.feemeasure_id = feemeasure_id;
	}
}
