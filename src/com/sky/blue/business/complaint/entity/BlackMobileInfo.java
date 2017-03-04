package com.sky.blue.business.complaint.entity;

import com.sky.blue.business.beans.BaseEntity;

public class BlackMobileInfo extends BaseEntity {
	private Integer cp_id;
	private String cp_name;
	private Integer product_id;
	private String product_name;
	private String ccp_id;
	private Integer op;
	private String mobile;
	private String imsi;
	private String province_name;
	private String city_name;
	private String dater;
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

	public String getCcp_id() {
		return ccp_id;
	}
	public void setCcp_id(String ccp_id) {
		this.ccp_id = ccp_id;
	}
	public Integer getOp() {
		return op;
	}
	public void setOp(Integer op) {
		this.op = op;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	public String getProvince_name() {
		return province_name;
	}
	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getDater() {
		return dater;
	}
	public void setDater(String dater) {
		this.dater = dater;
	}
	
	
}
