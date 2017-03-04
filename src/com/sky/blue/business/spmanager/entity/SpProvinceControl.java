package com.sky.blue.business.spmanager.entity;

import com.sky.blue.business.beans.BaseEntity;

public class SpProvinceControl extends BaseEntity{
	private Integer province_id;
	private String province_code;
	private String province_name;
	private Integer stat;
	private Integer stat_out;
	private Integer stat_spe;
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
	public Integer getStat() {
		return stat;
	}
	public void setStat(Integer stat) {
		this.stat = stat;
	}
	public Integer getStat_out() {
		return stat_out;
	}
	public void setStat_out(Integer stat_out) {
		this.stat_out = stat_out;
	}
	public Integer getStat_spe() {
		return stat_spe;
	}
	public void setStat_spe(Integer stat_spe) {
		this.stat_spe = stat_spe;
	}
	
	
}
