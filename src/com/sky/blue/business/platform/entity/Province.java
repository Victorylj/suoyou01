package com.sky.blue.business.platform.entity;

import com.sky.blue.business.beans.BaseEntity;

public class Province extends BaseEntity{
	private Integer province_id;
	private String province_code;
	private String province_name;
	public Integer getProvince_id() {
		return province_id;
	}
	public void setProvince_id(Integer province_id) {
		this.province_id = province_id;
	}
	public String getProvince_code() {
		return province_code;
	}
	public void setProvince_code(String province_code) {
		this.province_code = province_code;
	}
	public String getProvince_name() {
		return province_name;
	}
	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}
}
