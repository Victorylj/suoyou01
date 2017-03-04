package com.sky.blue.business.spmanager.entity;


import com.sky.blue.business.beans.BaseEntity;

public class SpFeecodeProvinceLimit extends BaseEntity {
	private Integer pro_limit_id;
	private Integer limit_id;
	private Integer pro_month_num;
	private Integer pro_day_num;
	private Integer pro_single_month_num;
	private Integer pro_single_day_num;
	private Integer province;
	private String province_name;
	private String pro_limit_start_time;
	private String pro_limit_end_time;
	private String pro_limit_time_str;
	private String pro_limit_city;
	
	private String pro_limit_start_hour;
	private String pro_limit_end_hour;
	private String pro_limit_hour_str;
	
	public String getPro_limit_city() {
		return pro_limit_city;
	}
	public void setPro_limit_city(String pro_limit_city) {
		this.pro_limit_city = pro_limit_city;
	}
	public Integer getPro_limit_id() {
		return pro_limit_id;
	}
	public void setPro_limit_id(Integer pro_limit_id) {
		this.pro_limit_id = pro_limit_id;
	}
	public Integer getLimit_id() {
		return limit_id;
	}
	public void setLimit_id(Integer limit_id) {
		this.limit_id = limit_id;
	}
	public Integer getPro_month_num() {
		return pro_month_num;
	}
	public void setPro_month_num(Integer pro_month_num) {
		this.pro_month_num = pro_month_num;
	}
	public Integer getPro_day_num() {
		return pro_day_num;
	}
	public void setPro_day_num(Integer pro_day_num) {
		this.pro_day_num = pro_day_num;
	}
	public Integer getPro_single_month_num() {
		return pro_single_month_num;
	}
	public void setPro_single_month_num(Integer pro_single_month_num) {
		this.pro_single_month_num = pro_single_month_num;
	}
	public Integer getPro_single_day_num() {
		return pro_single_day_num;
	}
	public void setPro_single_day_num(Integer pro_single_day_num) {
		this.pro_single_day_num = pro_single_day_num;
	}

	public String getProvince_name() {
		return province_name;
	}
	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}
	public String getPro_limit_start_time() {
		return pro_limit_start_time;
	}
	public void setPro_limit_start_time(String pro_limit_start_time) {
		this.pro_limit_start_time = pro_limit_start_time;
	}
	public String getPro_limit_end_time() {
		return pro_limit_end_time;
	}
	public void setPro_limit_end_time(String pro_limit_end_time) {
		this.pro_limit_end_time = pro_limit_end_time;
	}
	public String getPro_limit_time_str() {
		return pro_limit_time_str;
	}
	public void setPro_limit_time_str(String pro_limit_time_str) {
		this.pro_limit_time_str = pro_limit_time_str;
	}
	public String getPro_limit_start_hour() {
		return pro_limit_start_hour;
	}
	public void setPro_limit_start_hour(String pro_limit_start_hour) {
		this.pro_limit_start_hour = pro_limit_start_hour;
	}
	public String getPro_limit_end_hour() {
		return pro_limit_end_hour;
	}
	public void setPro_limit_end_hour(String pro_limit_end_hour) {
		this.pro_limit_end_hour = pro_limit_end_hour;
	}
	public String getPro_limit_hour_str() {
		return pro_limit_hour_str;
	}
	public void setPro_limit_hour_str(String pro_limit_hour_str) {
		this.pro_limit_hour_str = pro_limit_hour_str;
	}
	@Override
	public String toString() {
		return "SpFeecodeProvinceLimit [pro_limit_id=" + pro_limit_id
				+ ", limit_id=" + limit_id + ", pro_month_num=" + pro_month_num
				+ ", pro_day_num=" + pro_day_num + ", pro_single_month_num="
				+ pro_single_month_num + ", pro_single_day_num="
				+ pro_single_day_num + ", province=" + province
				+ ", province_name=" + province_name
				+ ", pro_limit_start_time=" + pro_limit_start_time
				+ ", pro_limit_end_time=" + pro_limit_end_time
				+ ", pro_limit_time_str=" + pro_limit_time_str
				+ ", pro_limit_start_hour=" + pro_limit_start_hour
				+ ", pro_limit_end_hour=" + pro_limit_end_hour
				+ ", pro_limit_hour_str=" + pro_limit_hour_str
				+ ", getArrayIds()=" + getArrayIds() + ", getRemarks()="
				+ getRemarks() + ", getCreate_time()=" + getCreate_time()
				+ ", getUpdate_time()=" + getUpdate_time()
				+ ", getCreate_name()=" + getCreate_name()
				+ ", getUpdate_name()=" + getUpdate_name() + "]";
	}
	public Integer getProvince() {
		return province;
	}
	public void setProvince(Integer province) {
		this.province = province;
	}
	
	
	
	
}
