package com.sky.blue.business.spmanager.entity;

import com.sky.blue.business.beans.BaseEntity;

public class SpFeecodeLimit extends BaseEntity {
	private Integer limit_id;
	private Integer feecode_id;
	private Integer command_id;
	
	private Integer sp_id;
	private String sp_name;
	private String feecode_name;
	private String feecode_number;
	private Integer month_num;
	private Integer day_num;
	private Integer single_month_num;
	private Integer single_day_num;
	private String limit_province;
	private String limit_province_name;
	private String province[];

	private String limit_start_time;
	private String limit_end_time;
	private String limit_time_str;
	
	private String limit_start_hour;
	private String limit_end_hour;
	private String limit_hour_str;
	private Integer rec_month_num;
	private Integer rec_day_num;
	private String feecodes;
	private Integer hour_num;
	
	private String create_name;
	
	public Integer getSp_id() {
		return sp_id;
	}
	public void setSp_id(Integer sp_id) {
		this.sp_id = sp_id;
	}
	public String getSp_name() {
		return sp_name;
	}
	public void setSp_name(String sp_name) {
		this.sp_name = sp_name;
	}
	private SpFeecodeProvinceLimit proLimitArr[]  ;
	
	public Integer getCommand_id() {
		return command_id;
	}
	public void setCommand_id(Integer command_id) {
		this.command_id = command_id;
	}
	public SpFeecodeProvinceLimit[] getProLimitArr() {
		return proLimitArr;
	}
	public void setProLimitArr(SpFeecodeProvinceLimit[] proLimitArr) {
		this.proLimitArr = proLimitArr;
	}
	public String getLimit_start_hour() {
		return limit_start_hour;
	}
	public void setLimit_start_hour(String limit_start_hour) {
		this.limit_start_hour = limit_start_hour;
	}
	public String getLimit_end_hour() {
		return limit_end_hour;
	}
	public void setLimit_end_hour(String limit_end_hour) {
		this.limit_end_hour = limit_end_hour;
	}
	public String getLimit_hour_str() {
		return limit_hour_str;
	}
	public void setLimit_hour_str(String limit_hour_str) {
		this.limit_hour_str = limit_hour_str;
	}
	public String getLimit_start_time() {
		return limit_start_time;
	}
	public void setLimit_start_time(String limit_start_time) {
		this.limit_start_time = limit_start_time;
	}
	public String getLimit_end_time() {
		return limit_end_time;
	}
	public void setLimit_end_time(String limit_end_time) {
		this.limit_end_time = limit_end_time;
	}
	public String getLimit_time_str() {
		return limit_time_str;
	}
	public void setLimit_time_str(String limit_time_str) {
		this.limit_time_str = limit_time_str;
	}
	private String limit_city_name;
	private Integer limit_city;
	private Integer limit_status;
	
	public String[] getProvince() {
		return province;
	}
	public void setProvince(String[] province) {
		this.province = province;
	}
	public Integer getLimit_id() {
		return limit_id;
	}
	public void setLimit_id(Integer limit_id) {
		this.limit_id = limit_id;
	}
	public Integer getFeecode_id() {
		return feecode_id;
	}
	public void setFeecode_id(Integer feecode_id) {
		this.feecode_id = feecode_id;
	}
	public String getFeecode_name() {
		return feecode_name;
	}
	public void setFeecode_name(String feecode_name) {
		this.feecode_name = feecode_name;
	}
	public String getFeecode_number() {
		return feecode_number;
	}
	public void setFeecode_number(String feecode_number) {
		this.feecode_number = feecode_number;
	}
	public Integer getMonth_num() {
		return month_num;
	}
	public void setMonth_num(Integer month_num) {
		this.month_num = month_num;
	}
	public Integer getDay_num() {
		return day_num;
	}
	public void setDay_num(Integer day_num) {
		this.day_num = day_num;
	}
	public Integer getSingle_month_num() {
		return single_month_num;
	}
	public void setSingle_month_num(Integer single_month_num) {
		this.single_month_num = single_month_num;
	}
	public Integer getSingle_day_num() {
		return single_day_num;
	}
	public void setSingle_day_num(Integer single_day_num) {
		this.single_day_num = single_day_num;
	}

	public String getLimit_province_name() {
		return limit_province_name;
	}
	public void setLimit_province_name(String limit_province_name) {
		this.limit_province_name = limit_province_name;
	}
	public String getLimit_city_name() {
		return limit_city_name;
	}
	public void setLimit_city_name(String limit_city_name) {
		this.limit_city_name = limit_city_name;
	}
	public Integer getLimit_city() {
		return limit_city;
	}
	public void setLimit_city(Integer limit_city) {
		this.limit_city = limit_city;
	}
	public Integer getLimit_status() {
		return limit_status;
	}
	public void setLimit_status(Integer limit_status) {
		this.limit_status = limit_status;
	}
	public String getLimit_province() {
		return limit_province;
	}
	public void setLimit_province(String limit_province) {
		this.limit_province = limit_province;
	}
	
	public String getCreate_name() {
		return create_name;
	}
	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}
	public Integer getRec_month_num() {
		return rec_month_num;
	}
	public void setRec_month_num(Integer rec_month_num) {
		this.rec_month_num = rec_month_num;
	}
	public Integer getRec_day_num() {
		return rec_day_num;
	}
	public void setRec_day_num(Integer rec_day_num) {
		this.rec_day_num = rec_day_num;
	}
	public String getFeecodes() {
		return feecodes;
	}
	public void setFeecodes(String feecodes) {
		this.feecodes = feecodes;
	}
	
	public Integer getHour_num() {
		return hour_num;
	}
	public void setHour_num(Integer hour_num) {
		this.hour_num = hour_num;
	}
	@Override
	public String toString() {
		return "SpFeecodeLimit [limit_id=" + limit_id + ", feecode_id="
				+ feecode_id + ", feecode_name=" + feecode_name
				+ ", feecode_number=" + feecode_number + ", month_num="
				+ month_num + ", rec_day_num=" + rec_day_num+ ", rec_month_num=" + rec_month_num
				+ ", day_num=" + day_num + ", single_month_num="
				+ single_month_num + ", single_day_num=" + single_day_num
				+ ", limit_province=" + limit_province
				+ ", limit_province_name=" + limit_province_name
				+ ", limit_city_name=" + limit_city_name + ", limit_city="
				+ limit_city + ", limit_status=" + limit_status
				+ ", getArrayIds()=" + getArrayIds() + ", getRemarks()="
				+ getRemarks() + ", getCreate_time()=" + getCreate_time()
				+ ", getUpdate_time()=" + getUpdate_time()
				+ ", getCreate_name()=" + getCreate_name()
				+ ", getUpdate_name()=" + getUpdate_name() + "]";
	}
}
