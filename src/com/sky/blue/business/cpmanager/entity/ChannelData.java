package com.sky.blue.business.cpmanager.entity;

import com.sky.blue.business.beans.BaseEntity;

public class ChannelData extends BaseEntity {
	private Integer ch_data_id;
	private Integer ch_id;
	private String ch_name;
	private Integer data_init;
	private Integer data_fee;
	private Integer data_div;
	private Integer data_ret;
	private Integer data_cpa;
	private Integer data_cps;
	private Integer data_cpc; 
	private String dater;
	
	
	
	public String getDater() {
		return dater;
	}
	public void setDater(String dater) {
		this.dater = dater;
	}
	public Integer getCh_data_id() {
		return ch_data_id;
	}
	public void setCh_data_id(Integer ch_data_id) {
		this.ch_data_id = ch_data_id;
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
	public Integer getData_cpa() {
		return data_cpa;
	}
	public void setData_cpa(Integer data_cpa) {
		this.data_cpa = data_cpa;
	}
	public Integer getData_cps() {
		return data_cps;
	}
	public void setData_cps(Integer data_cps) {
		this.data_cps = data_cps;
	}
	public Integer getData_cpc() {
		return data_cpc;
	}
	public void setData_cpc(Integer data_cpc) {
		this.data_cpc = data_cpc;
	}
	public Integer getData_init() {
		return data_init;
	}
	public void setData_init(Integer data_init) {
		this.data_init = data_init;
	}
	public Integer getData_fee() {
		return data_fee;
	}
	public void setData_fee(Integer data_fee) {
		this.data_fee = data_fee;
	}
	public Integer getData_div() {
		return data_div;
	}
	public void setData_div(Integer data_div) {
		this.data_div = data_div;
	}
	public Integer getData_ret() {
		return data_ret;
	}
	public void setData_ret(Integer data_ret) {
		this.data_ret = data_ret;
	}
	
	
	
}
