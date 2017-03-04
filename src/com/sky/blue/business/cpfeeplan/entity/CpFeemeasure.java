package com.sky.blue.business.cpfeeplan.entity;

import com.sky.blue.business.beans.BaseEntity;

public class CpFeemeasure extends BaseEntity {
	private Integer feemeasure_id;
	private String feeplan_name;
	public String getFeeplan_name() {
		return feeplan_name;
	}
	public void setFeeplan_name(String feeplan_name) {
		this.feeplan_name = feeplan_name;
	}
	private Integer feeplan_id;
	private String feemeasure_name;
	private Integer  feemeasure_op;
	private Integer feemeasure_is_pop;
	private Integer feemeasure_fee;
	private String feemeasure_province_name;
	private Integer feemeasure_province;
	private String feemeasure_city_name;
	private Integer link_id;
	private String create_name;
	public Integer getLink_id() {
		return link_id;
	}
	public void setLink_id(Integer link_id) {
		this.link_id = link_id;
	}
	public String getFeemeasure_province_name() {
		return feemeasure_province_name;
	}
	public void setFeemeasure_province_name(String feemeasure_province_name) {
		this.feemeasure_province_name = feemeasure_province_name;
	}
	public String getFeemeasure_city_name() {
		return feemeasure_city_name;
	}
	public void setFeemeasure_city_name(String feemeasure_city_name) {
		this.feemeasure_city_name = feemeasure_city_name;
	}
	private Integer feemeasure_city;
	public Integer getFeemeasure_id() {
		return feemeasure_id;
	}
	public void setFeemeasure_id(Integer feemeasure_id) {
		this.feemeasure_id = feemeasure_id;
	}
	public Integer getFeeplan_id() {
		return feeplan_id;
	}
	public void setFeeplan_id(Integer feeplan_id) {
		this.feeplan_id = feeplan_id;
	}
	public String getFeemeasure_name() {
		return feemeasure_name;
	}
	public void setFeemeasure_name(String feemeasure_name) {
		this.feemeasure_name = feemeasure_name;
	}
	public Integer getFeemeasure_op() {
		return feemeasure_op;
	}
	public void setFeemeasure_op(Integer feemeasure_op) {
		this.feemeasure_op = feemeasure_op;
	}
	public Integer getFeemeasure_is_pop() {
		return feemeasure_is_pop;
	}
	public void setFeemeasure_is_pop(Integer feemeasure_is_pop) {
		this.feemeasure_is_pop = feemeasure_is_pop;
	}
	public Integer getFeemeasure_fee() {
		return feemeasure_fee;
	}
	public void setFeemeasure_fee(Integer feemeasure_fee) {
		this.feemeasure_fee = feemeasure_fee;
	}
	public Integer getFeemeasure_province() {
		return feemeasure_province;
	}
	public void setFeemeasure_province(Integer feemeasure_province) {
		this.feemeasure_province = feemeasure_province;
	}
	public Integer getFeemeasure_city() {
		return feemeasure_city;
	}
	public void setFeemeasure_city(Integer feemeasure_city) {
		this.feemeasure_city = feemeasure_city;
	}
	public String getCreate_name() {
		return create_name;
	}
	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}
	
}
