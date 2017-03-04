package com.sky.blue.business.cpmanager.entity;

import com.sky.blue.business.beans.BaseEntity;

public class ChannelProduct extends BaseEntity {
	private Integer ch_prod_id;
	private Integer ch_id;
	private String ch_name;
	private Integer product_id;
	private String product_name;
	private Integer cp_id;
	private String cp_name;
	private Integer appfee_id;
	
	
	
	public Integer getCh_prod_id() {
		return ch_prod_id;
	}
	public void setCh_prod_id(Integer ch_prod_id) {
		this.ch_prod_id = ch_prod_id;
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
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
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
	public Integer getAppfee_id() {
		return appfee_id;
	}
	public void setAppfee_id(Integer appfee_id) {
		this.appfee_id = appfee_id;
	}
	
	
}
