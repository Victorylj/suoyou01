package com.sky.blue.business.cpmanager.entity;

import com.sky.blue.business.beans.BaseEntity;

public class CpProduct extends BaseEntity {
	private Integer product_id;
	private Integer cp_id;
	private String cp_name;
	public String getCp_name() {
		return cp_name;
	}
	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}
	private String product_name;
	private String product_code;
	private String product_package;
	private Integer product_fee;
	private Integer is_overfee;
	private Integer product_status;
	private String create_name;
	private Integer is_pop;
	private String province[];
	private String provincestr;

	public String[] getProvince() {
		return province;
	}
	public void setProvince(String[] province) {
		this.province = province;
	}

	public String getProvincestr() {
		return provincestr;
	}
	public void setProvincestr(String provincestr) {
		this.provincestr = provincestr;
	}
	public Integer getIs_pop() {
		return is_pop;
	}
	public void setIs_pop(Integer is_pop) {
		this.is_pop = is_pop;
	}
	public String getCreate_name() {
		return create_name;
	}
	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getCp_id() {
		return cp_id;
	}
	public void setCp_id(Integer cp_id) {
		this.cp_id = cp_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getProduct_package() {
		return product_package;
	}
	public void setProduct_package(String product_package) {
		this.product_package = product_package;
	}
	public Integer getProduct_fee() {
		return product_fee;
	}
	public void setProduct_fee(Integer product_fee) {
		this.product_fee = product_fee;
	}
	public Integer getIs_overfee() {
		return is_overfee;
	}
	public void setIs_overfee(Integer is_overfee) {
		this.is_overfee = is_overfee;
	}
	public Integer getProduct_status() {
		return product_status;
	}
	public void setProduct_status(Integer product_status) {
		this.product_status = product_status;
	}
	@Override
	public String toString() {
		return "CpProduct [product_id=" + product_id + ", cp_id=" + cp_id
				+ ", product_name=" + product_name + ", product_code="
				+ product_code + ", product_package=" + product_package
				+ ", product_fee=" + product_fee + ", is_overfee=" + is_overfee
				+ ", product_status=" + product_status + ", getArrayIds()="
				+ getArrayIds() + ", getRemarks()=" + getRemarks()
				+ ", getCreate_time()=" + getCreate_time()
				+ ", getUpdate_time()=" + getUpdate_time()
				+ ", getCreate_name()=" + getCreate_name()
				+ ", getUpdate_name()=" + getUpdate_name() + "]";
	}
	
}
