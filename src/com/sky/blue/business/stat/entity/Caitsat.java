package com.sky.blue.business.stat.entity;

import com.sky.blue.business.beans.BaseEntity;

public class Caitsat extends BaseEntity {
	private String dater;
	private Long cp_id;
	private String cp_name;
	private Long product_id;
	private String product_name ;
	private String ccp_id;
	private int n;
	public String getDater() {
		return dater;
	}
	public void setDater(String dater) {
		this.dater = dater;
	}
	public Long getCp_id() {
		return cp_id;
	}
	public void setCp_id(Long cp_id) {
		this.cp_id = cp_id;
	}
	public String getCp_name() {
		return cp_name;
	}
	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getCcp_id() {
		return ccp_id;
	}
	public void setCcp_id(String ccp_id) {
		this.ccp_id = ccp_id;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	

	


}
